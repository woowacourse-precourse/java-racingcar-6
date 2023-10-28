package racingcar.controller;

import racingcar.service.UserService;

public class UserController {

    private final UserService userService = new UserService();

    public void makeUser(){
        userService.makeUser();
    }
}
