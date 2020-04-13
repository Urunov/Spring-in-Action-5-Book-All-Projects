package spring.security;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

/**
 * @Created 17 / 03 / 2020 - 6:43 PM
 * @project BootSecure
 * @Author Hamdamboy
 */

@Data
@Entity
//@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
////@RequiredArgsConstructor

public class User implements UserDetails {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   private String username;
   private String password;
   private String fullname;
   private String street;
   private String city;
   private String state;
   private String zip;
   private String phoneNumber;

    public User(Long id, String city, String state, String zip) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return  true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


//https://mkyong.com/spring-boot/
//https://github.com/dangeabunea/RomanianCoderExamples/blob/master/SpringBootSecurity/Forms/pom.xml
//https://spring.io/guides/gs/authenticating-ldap/