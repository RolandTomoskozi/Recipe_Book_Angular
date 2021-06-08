package at.rt.sample.springboot.security;

import lombok.Data;

import java.io.Serializable;

/**
 * This class is required for storing the username and password we recieve from the client.
 *
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 02.06.2021
 */
@Data
public class JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    private String username;
    private String password;
}
