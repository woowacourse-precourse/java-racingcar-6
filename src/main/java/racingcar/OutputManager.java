package racingcar;

import java.util.List;

public class OutputManager {
    public void printRaceResult(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
