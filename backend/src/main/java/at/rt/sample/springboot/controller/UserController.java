package at.rt.sample.springboot.controller;

import at.rt.sample.springboot.dto.model.UserModel;
import at.rt.sample.springboot.service.api.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Roland Tömösközi (roland.toemoeskoezi@activesolution.at)
 * Created on 02.06.2021
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Page<UserModel> findAll(Pageable pageable) {
        return userService.findAll(pageable);
    }

    @PostMapping
    public UserModel createUser(@RequestBody @Valid UserModel user) {
        return userService.createUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody @Valid UserModel user) {
        userService.updateUser(user);
    }

    @GetMapping("/{id}")
    public UserModel findOne(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

}
