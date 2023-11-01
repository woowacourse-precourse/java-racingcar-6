package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingGame {
    private List<RacingCar> racingCars;
    private Winner winner;
    private int gameCount;

    private void inputGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        int tempGameCount = Integer.parseInt(readLine());
        ErrorCatcher.gameCountCheck(tempGameCount);
        this.gameCount = tempGameCount;
    }

    private void inputRacingCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        this.racingCars = new ArrayList<RacingCar>();

        List<String> tempRacingCars = List.of(readLine().split(","));
        ErrorCatcher.carNamingCheck(tempRacingCars);
        for (String newRacingCar : tempRacingCars) {
            addRacingCar(newRacingCar);
        }
    }
}
