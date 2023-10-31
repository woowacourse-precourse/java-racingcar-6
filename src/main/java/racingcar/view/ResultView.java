package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarFactory;

public class ResultView {

    private static void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printRaceResult(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.println("최종 우승자 : " + CarFactory.toNameString(winners));
    }
}
