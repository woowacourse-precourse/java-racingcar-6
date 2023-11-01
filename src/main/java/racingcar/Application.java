package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.util.PlayRule;
import racingcar.view.RacingView;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingView racingCar = new RacingView(); // view
        PlayRule rules = new PlayRule();
        GameController gameController = new GameController(racingCar, rules); // controller
        try {
            gameController.gameStart();
            gameController.gameOn();
        } catch (Exception e) {
            throw new IllegalArgumentException("유효하지 않은 데이터입니다.");
        }
    }
}
