package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import domain.RacingCar;
import domain.RacingGameStartManager;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGameStartManager racingGameStartManager = new RacingGameStartManager();
        String[] inputRacingCarNames = inputRacingCarNames();
        Set<RacingCar> racingCarSet = racingGameStartManager.createRacingCarSet(inputRacingCarNames);
    }

    private static String[] inputRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputRacingCarName = readLine();

        return inputRacingCarName.split(",");
    }

}
