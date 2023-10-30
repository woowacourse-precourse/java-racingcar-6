package racingcar;

import racingcar.View.InputMessage;
import racingcar.View.SystemMessage;
import racingcar.controller.GameController;
import racingcar.model.CarAction;
import racingcar.model.Cars;
import racingcar.model.Referee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();
        gameController.playGame();
    }
}
