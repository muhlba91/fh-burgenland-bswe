package io.muehlbachler.bswe.service.impl;

import java.util.ArrayList;
import java.util.List;

import io.muehlbachler.bswe.error.ApiException;
import io.muehlbachler.bswe.model.User;
import io.muehlbachler.bswe.repository.UserRepository;
import io.muehlbachler.bswe.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation of userService for handling user-related operations.
 *
 * Uses userRepository for persistence and runs in a transactional context.
 */

@AllArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {
    /** Logger instance for this service. */
  private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    /** Repository for persisting and retrieving {@link User} entities. */
  @Autowired
  private final UserRepository userRepository;
    /**
     * Checks whether a user with the given userId exists.
     *
     * @param userId the unique identifier of the user
     * @return {@code true} if the user exists, {@code false} otherwise
     */
  @Override
  public boolean exists(final String userId) {
      if (userId == null || userId.isEmpty()) {
          return false;
      }
     return userRepository.existsById(userId);
  }
    /**
     * Retrieves a list of all users.
     *
     * @return a list of user objects, possibly empty but never {@code null}
     */
  @Override
  public List<User> list() {
    final List<User> result = new ArrayList<>();
      userRepository.findAll().forEach(result::add);
    return result;
  }
    /**
     * Saves a user to the repository.
     *
     * @param user the user to persist
     * @return the persisted user entity
     * @throws ApiException if the user cannot be saved (e.g. validation failure, repository error)
     */
  @Override
  public User save(final User user) throws ApiException {
    // FIXME: implement
    return user;
  }
    /**
     * Deletes a user with the given userId.
     *
     * @param userId the unique identifier of the user to be removed
     * @return true if the deletion was successful, false otherwise
     */
  @Override
  public boolean delete(final String userId) {
    // FIXME: implement
    return true;
  }
}
