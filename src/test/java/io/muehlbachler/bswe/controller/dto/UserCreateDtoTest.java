package io.muehlbachler.bswe.controller.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class UserCreateDtoTest {
  @Test
  void testNoArgsConstructor() {
    final UserCreateDto dto = new UserCreateDto();
    assertNotNull(dto);
  }

  @Test
  void testAllArgsConstructor() {
    final UserCreateDto dto = new UserCreateDto("1","username");
    assertNotNull(dto);
    assertEquals("username", dto.getUsername());
  }

  @Test
  void testSetters() {
    final UserCreateDto dto = new UserCreateDto();
    dto.setUsername("username");

    assertEquals("username", dto.getUsername());
  }
}
