package at.rt.sample.springboot.service.api;

import at.rt.sample.springboot.dto.model.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 02.06.2021
 */
public interface UserService {
    UserModel findById(Long id);

    Page<UserModel> findAll(Pageable pageable);

    UserModel createUser(UserModel user);

    void updateUser(UserModel user);

    Long getCurrentUserId();
}
