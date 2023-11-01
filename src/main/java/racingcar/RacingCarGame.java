package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private static List<RacingCar> racingCarList = new ArrayList<>();

    public static void start() {
        RacingCarController.setRacingCarList(racingCarList);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> stringList = InputOutputInterface.listenCarName();
        for (String s : stringList) {
            RacingCarController.registerRacingCar(s);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int movingCount = InputOutputInterface.listenMovingCount();

        for (int i = 0; i < movingCount; i++) {
            for (RacingCar rc : racingCarList) {
                RacingCarController.updateRacingCar(rc);
                InputOutputInterface.printRacingCarInfo(rc);
            }
        }

        List<RacingCar> winners = RacingCarController.findWinner();
        InputOutputInterface.printWinner(winners);
    }
}
