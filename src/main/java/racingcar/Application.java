package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.RacingCarController;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.util.GlobalExceptionHandler;

import java.util.*;

import static java.util.Collections.max;

public class Application {
    public static void main(String[] args) {

        final RacingCarController racingCarController = new RacingCarController();
        racingCarController.startRacingCar();

    }
}
