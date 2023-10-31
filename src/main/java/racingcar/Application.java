package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.RaceController;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        RaceController raceController = new RaceController(new RaceService());

        raceController.startRace();

    }
}
