package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import domain.RacingCar;
import domain.RacingGameStartManager;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGameStartManager racingGameStartManager = new RacingGameStartManager();

        // 자동차 경주에 참여할 자동차 세팅
        String[] inputRacingCarNames = inputRacingCarNames();
        Set<RacingCar> racingCarSet = racingGameStartManager.createRacingCarSet(inputRacingCarNames);

        // 경주 진행 시 이동 시도 횟수 세팅
        String inputRacingCarMoveNum = inputRacingCarMoveNum();
        int racingCarMoveNum = racingGameStartManager.convertInputRacingCarMoveNumToInt(inputRacingCarMoveNum);
    }

    private static String[] inputRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputRacingCarName = readLine();

        return inputRacingCarName.split(",");
    }

    private static String inputRacingCarMoveNum() {
        System.out.println("시도할 회수는 몇회인가요?");

        return readLine();
    }

}
