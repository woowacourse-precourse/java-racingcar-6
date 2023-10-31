package racingcar;

import racingcar.controller.RacingcarController;

public class Application {

    public static void main(String[] args) throws IllegalArgumentException{
        RacingcarController racingcarController = new RacingcarController();
        racingcarController.start();
    }
}
