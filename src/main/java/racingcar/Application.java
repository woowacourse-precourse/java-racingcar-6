package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

import racingcar.controller.RacingcarController;
import racingcar.domain.Racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingcarController racingcarController = new RacingcarController();
        racingcarController.run();
    }
}
