package racingcar.manager.controller;

import racingcar.manager.model.User;
import racingcar.manager.view.UserView;

public class UserController {
    private final UserView userView = new UserView();
    public Integer getUserTryCount(){
        Integer tryCount = userView.inputTryCount();
        User user = new User(tryCount);
        return user.getTryCount();
    }
}
