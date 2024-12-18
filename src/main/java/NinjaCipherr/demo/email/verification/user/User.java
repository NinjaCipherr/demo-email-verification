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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.SequenceGenerators;
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
  @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)

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

  public String getPassword() {

    return this.password;
  }

  public String getUsername() {
    return this.email;
  }

  public boolean isAccountNonExpired() {
    return true;
  }

  public boolean isAccountNonLocked() {
    return !this.locked;
  }

  public boolean isCredentialsNonExpired() {
    return true;
  }

  public boolean isEnabled() {
    return enable;
  }
}
