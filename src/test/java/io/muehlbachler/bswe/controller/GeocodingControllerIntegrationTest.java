package io.muehlbachler.bswe.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.google.gson.Gson;
import io.muehlbachler.bswe.configuration.ApiConfiguration;
import io.muehlbachler.bswe.model.Coordinates;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.wiremock.spring.ConfigureWireMock;
import org.wiremock.spring.EnableWireMock;
import org.wiremock.spring.InjectWireMock;

@EnableWireMock({
    @ConfigureWireMock(name = "geocoding-service", baseUrlProperties = "geocoding-service.url", portProperties = "geocoding-service.port", filesUnderDirectory = "wiremock/geocoding-service")
})
@SpringBootTest
@AutoConfigureMockMvc
public class GeocodingControllerIntegrationTest {
  @InjectWireMock("geocoding-service")
  private WireMockServer geocodingMockServer;

  @Autowired
  private MockMvc mvc;

  @MockitoBean
  private ApiConfiguration apiConfiguration;

  @BeforeEach
  public void setUp() {
    when(apiConfiguration.getGeocoding())
        .thenReturn(
            new ApiConfiguration.ApiConnectionInformation(geocodingMockServer.baseUrl() + "/{name}"));
  }

  @AfterEach
  public void tearDown() {
    verifyNoMoreInteractions(apiConfiguration);
  }

  @Test
  void testGet() throws Exception {
    MvcResult result = mvc
        .perform(MockMvcRequestBuilders.get("/api/geocoding/?location={location}", "Vienna, Austria"))
        .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    Coordinates coordinates = new Gson().fromJson(result.getResponse().getContentAsString(),
        Coordinates.class);
    assertNotNull(coordinates);
    assertEquals(22.0, coordinates.getLatitude());
    assertEquals(11.0, coordinates.getLongitude());
    assertEquals(33.0, coordinates.getElevation());

    verify(apiConfiguration, times(1)).getGeocoding();
  }

  // TODO: add more tests
}
