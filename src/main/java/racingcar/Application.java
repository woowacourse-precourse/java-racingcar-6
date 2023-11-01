package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import domain.RacingCar;
import domain.RacingGamePlayManager;
import domain.RacingGameStartManager;
import java.util.Set;

public class Application {
    private static final int RANDOM_MIN_VALUE = 1;
    private static final int RANDOM_MAX_VALUE = 9;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGameStartManager racingGameStartManager = new RacingGameStartManager();
        RacingGamePlayManager racingGamePlayManager = new RacingGamePlayManager();

        // 자동차 경주에 참여할 자동차 세팅
        String[] inputRacingCarNames = inputRacingCarNames();
        Set<RacingCar> racingCarSet = racingGameStartManager.createRacingCarSet(inputRacingCarNames);

        // 경주 진행 시 이동 시도 횟수 세팅
        String inputRacingCarMoveNum = inputRacingCarMoveNum();
        int racingCarMoveNum = racingGameStartManager.convertInputRacingCarMoveNumToInt(inputRacingCarMoveNum);

        // 경주 진행
        for (RacingCar racingCar : racingCarSet) {
            int pickNumberInRange = pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE);
            racingGamePlayManager.moveOrStayRacingCars(racingCar, pickNumberInRange);
        }

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
