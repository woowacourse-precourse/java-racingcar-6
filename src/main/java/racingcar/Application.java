package racingcar;

import racingcar.controller.GameController;
import racingcar.view.RacingCar;

import java.io.IOException;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            RacingCar racingCar = new RacingCar(); // view
            GameController gameController = new GameController(racingCar); // controller

            gameController.GameStart();
            gameController.play();
        } catch (Exception e) {
            throw new IllegalArgumentException("유효하지 않은 데이터입니다.");
        }
    }
}
