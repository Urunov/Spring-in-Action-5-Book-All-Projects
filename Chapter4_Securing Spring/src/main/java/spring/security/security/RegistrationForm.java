package spring.security.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.security.User;

/**
 * @Created 17 / 03 / 2020 - 6:45 PM
 * @project BootSecure
 * @Author Hamdamboy
 */

@Data
public class RegistrationForm {

    //
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;


    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), fullname, street, city, state, zip, phone);
    }

}
