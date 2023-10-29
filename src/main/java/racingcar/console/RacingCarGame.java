package racingcar.console;

import racingcar.domain.RacingCar;
import racingcar.service.RacingCarService;
import racingcar.util.constant.ProductConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.util.constant.ProductConstant.*;

public class RacingCarGame {
    public int start = 0;
    public RacingCarService racingCarService;

    public void playGame() {

        racingCarService = new RacingCarService();

        System.out.println(INPUT_NAMES);
        ArrayList<RacingCar> racingCars = racingCarService.initRacingCarMembers();

        System.out.println(INPUT_NUMBER_OF_ATTEMPTS);
        int attempts = racingCarService.initNumberOfAttempts();

        System.out.println(GAME_RESULT);

        while (start < attempts) {
            racingCars = racingCarService.movingForward(racingCars);
            racingCarService.getRaceResult(racingCars);

            start = racingCarService.addTime(start);
        }

        racingCarService.getFinalWinner(racingCars);
    }
}
