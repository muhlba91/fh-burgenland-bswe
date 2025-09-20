package io.muehlbachler.bswe.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import com.google.gson.Gson;
import io.muehlbachler.bswe.controller.dto.UserCreateDto;
import io.muehlbachler.bswe.controller.dto.UserListDto;
import io.muehlbachler.bswe.model.User;
import io.muehlbachler.bswe.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
  @Autowired
  private MockMvc mvc;
  @Autowired
  private UserRepository repository;

  private User user;
  private UserCreateDto userDto;

  @BeforeEach
  public void setUp() {
    repository.deleteAll();

    user = new User();
    user.setUsername("username");
    user.withId(UUID.randomUUID().toString());
    userDto = new UserCreateDto();
    userDto.setUsername("username");
    userDto.setId(UUID.randomUUID().toString());
  }

  @AfterEach
  public void tearDown() {
    repository.deleteAll();
  }

  @Test
  public void testList() throws Exception {
    repository.save(user);

    MvcResult result = mvc
        .perform(MockMvcRequestBuilders.get("/api/user/"))
        .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    UserListDto usersResult = new Gson().fromJson(result.getResponse().getContentAsString(),
        UserListDto.class);
    assertNotNull(usersResult);
    assertEquals(1, usersResult.getUsers().size());
    assertEquals(user.getUsername(), usersResult.getUsers().get(0).getUsername());
  }

  @Test
  public void testListEmpty() throws Exception {
    MvcResult result = mvc
        .perform(MockMvcRequestBuilders.get("/api/user/"))
        .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    UserListDto usersResult = new Gson().fromJson(result.getResponse().getContentAsString(),
        UserListDto.class);
    assertNotNull(usersResult);
    assertTrue(usersResult.getUsers().isEmpty());
  }

//  @Test
//  public void testCreate() throws Exception {
//    MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/api/user/")
//        .contentType(MediaType.APPLICATION_JSON)
//        .content(new Gson().toJson(userDto)))
//        .andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();
//    User user = new Gson().fromJson(result.getResponse().getContentAsString(),
//        User.class);
//    assertNotNull(user);
//    assertEquals(userDto.getUsername(), user.getUsername());
//    assertTrue(repository.existsById(user.getId()));
//  }

  // TODO: add more tests
}
