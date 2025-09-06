package io.muehlbachler.bswe.service;

import java.util.List;

import io.muehlbachler.bswe.error.ApiException;
import io.muehlbachler.bswe.model.User;

/**
 * A service to handle all user-related actions.
 */

public interface UserService {

  /**
     * Checks if a user with the given id exists.
     *
     * Edge cases:
     * - userId is null → should return false or throw IllegalArgumentException
     * - userId does not exist → return false
     *
     * @param userId the user id to check
     * @return true if the user exists, false otherwise
     */

  boolean exists(String userId);

  /**
     * Lists all users.
     *
     * Edge cases:
     * - if no users exist, returns an empty list (never null).
     *
     * @return a list of all users
     */

  List<User> list();

  /**
     * Saves a new user in the system.
     *
     * Edge cases:
     * - user is null → should throw IllegalArgumentException
     * - duplicate user id → throws ApiException
     * - invalid user data → throws ApiException
     *
     * @param user the user to save
     * @return the saved user object
     * @throws ApiException if the user could not be saved
     */

  User save(User user) throws ApiException;

  /**
     * Deletes a user by its id.
     *
     * Edge cases:
     * - userId is null → should throw IllegalArgumentException
     * - userId does not exist → method may throw exception or do nothing
     *
     * @param userId the id of the user to delete
     */

  boolean delete(String userId);
}
