package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Race;

public class OutputView {

    public static void raceStart() {
        System.out.println("실행 결과");
    }

    public static void raceResult(Race race) {
        for (Car car : race.getCars()) {
            System.out.print(car.getName() + " : ");
            printPosition(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    public static void printPosition(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
    }

}
