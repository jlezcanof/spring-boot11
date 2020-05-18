package edu.lez.boot8java11.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import edu.lez.boot8java11.model.User;
import lombok.NonNull;

/**
 * Type UserRepository.
 */
@RepositoryRestResource(collectionResourceRel = "users", path ="users")
public interface UserRepository extends JpaRepository<User, String> {

  /**
   * It removes records which 'created' is older than specified instant.<br>
   * <br>
   * 
   * @param instant -
   * @return -
   */
  long deleteByCreatedBefore(final @NonNull Date instant);

}
