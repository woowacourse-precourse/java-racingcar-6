package racingcar;

import racingcar.controller.GameController;
import racingcar.view.RacingView;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingView racingCar = new RacingView(); // view
        GameController gameController = new GameController(racingCar); // controller
        try {
            gameController.gameStart();
            gameController.play();
        } catch (Exception e) {
            throw new IllegalArgumentException("유효하지 않은 데이터입니다.");
        }
    }
}
