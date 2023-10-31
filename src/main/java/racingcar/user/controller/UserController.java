package racingcar.user.controller;

import racingcar.user.model.User;
import racingcar.user.view.UserView;

public class UserController {
    private UserView userView = new UserView();

    public UserController(){
        Integer tryCount = userView.inputTryCount();
        User user = new User(tryCount);
    }
}
