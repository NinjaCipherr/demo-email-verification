package NinjaCipherr.demo.email.verification.user;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * User
 */
@Entity
@Getter
@Setter
public class User implements UserDetails {
  // lam 1 layer de cung cap thong tin cua user
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private UserRole userRole;
  private boolean locked = false;
  private boolean enable = false;

  public User(Long id, String firstName, String lastName, String email, String password, UserRole userRole) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.userRole = userRole;
  }

  public Collection<? extends GrantedAuthority> getAuthorities() {
    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userRole.name());
    return Collections.singleton(authority);
    // li do cho viec toi muon return lai collection la muon tra vce 1 gia tri bat
    // bien
  }
}
