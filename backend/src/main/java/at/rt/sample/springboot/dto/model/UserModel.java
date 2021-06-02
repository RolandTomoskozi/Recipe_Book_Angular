package at.rt.sample.springboot.dto.model;

import at.rt.sample.springboot.dto.model.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserModel extends BaseModel<Long> {

    @Length(min = 4, max = 24)
    private String username;

    @Email
    @NotNull
    private String email;

    private String password;

    private List<String> authorities;

    private Long version;
}
