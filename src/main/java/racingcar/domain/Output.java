package racingcar.domain;

import java.util.List;

public class Output {
    public static void printCar(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getMileage(); ++i) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
