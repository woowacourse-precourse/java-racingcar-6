package racingcar.console;

import racingcar.domain.RacingCar;
import racingcar.service.RacingCarService;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.util.constant.ProductConstant.*;

public class RacingCarGame {
    public int start = 0;
    public String input = null;
    public RacingCarService racingCarService;

    public void playGame() {

        racingCarService = new RacingCarService();

        System.out.println(INPUT_NAMES);
        input = readLine();
        ArrayList<RacingCar> racingCars = racingCarService.initRacingCarMembers(input);

        System.out.println(INPUT_NUMBER_OF_ATTEMPTS);
        input = readLine();
        int attempts = racingCarService.initNumberOfAttempts(input);

        System.out.println(GAME_RESULT);

        while (start < attempts) {
            racingCars = racingCarService.movingForward(racingCars);
            racingCarService.getRaceResult(racingCars);

            start = racingCarService.addTime(start);
        }

        ArrayList<String> finalWinner = racingCarService.getFinalWinner(racingCars);
        racingCarService.printWinners(finalWinner);
    }
}
