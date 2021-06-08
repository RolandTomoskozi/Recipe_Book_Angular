package at.rt.sample.springboot.security;

import lombok.Data;

import java.io.Serializable;

/**
 * This is class is required for creating a response containing the JWT to be returned to the user.
 *
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 02.06.2021
 */
@Data
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;
    private final String token;
}
