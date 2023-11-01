package racingcar.util;

import racingcar.domain.RacingCar;

import java.util.List;

public class OutputView {


    public static void printResult(List<RacingCar> racingCars) {

        System.out.println("실행결과");

        for (RacingCar car : racingCars) {
            System.out.println(car.getRacingResult());
        }
    }

    public static void printTotalResult(List<String> winnerList ) {

        String winners = String.join(", ", winnerList);
        System.out.println("최종 우승자 : " + winners);
    }
}
