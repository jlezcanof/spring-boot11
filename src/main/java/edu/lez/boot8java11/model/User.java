package edu.lez.boot8java11.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * <br>
 * JPA entity that represents details a 'User', such as the instant or the UUID.<br>
 ¡
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "user")
public class User {

  /**
   * Primary key.<br>
   * An UUID has 36 chars as in: xxxxxxxx-xxxx-Mxxx-Nxxx-xxxxxxxxxxxx<br>
   */
  @Id
  private String uuid;

  /**
   * 
   * not null default current_timestamp. Instant que the record was created.<br>
   * <br>
   * Might be better using the immutable type java.time.Instant
   */
  @Column(name = "created", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @Getter(AccessLevel.NONE)
  private Date created;

  /**
   * Nullable. 
   */
  @Column(name = "user_id")
  private Long userId;
  
  @Column(nullable = false)
  @Setter()
  @Getter(AccessLevel.NONE)
  private String name;

  /**
   * Constructor.
   * 
   * @param uuid    Primary key
   * @param userIdp Nullable user id
   * @param name name of the user
   */
  public User(final @NonNull UUID uuid, Long userId, String name) {
    this.setUuid(uuid.toString());
    this.setUserId(userId);
    this.setName(name);
  }

  /**
   * .
   */
  @PrePersist
  protected void onCreate() {
    // default current_timestamp
    this.created = new Date();
  }

  /**
   * Avoid exposing internal representation.
   * 
   * @return -
   */
  public Date getCreated() {
    return (Date) this.created.clone();
  }
  
 

}
