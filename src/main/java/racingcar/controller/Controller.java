package racingcar.controller;

import racingcar.service.InitService;

public class Controller {

    InitService initService = new InitService();

    public void start() {
        initService.initCarList();;
    }
}
