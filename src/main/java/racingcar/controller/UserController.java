package racingcar.controller;

import java.util.List;
import racingcar.entity.User;
import racingcar.service.UserService;

public class UserController {

    private final UserService userService = new UserService();

    public List<User> makeUser(){
        return userService.makeUser();
    }
}
