package racingcar.domain;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Util {

    public static void printResult(Car curCar) {
        System.out.print(curCar.name + " : ");
        for (int i = 0; i < curCar.distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static int getMaxDistance(List<Car> Cars) {
        int maxDistance = 0;
        for (Car curCar : Cars) {
            if (curCar.distance > maxDistance) {
                maxDistance = curCar.distance;
            }
        }
        return maxDistance;
    }

    public static String[] getCarNames() {
        return readLine().split(",");
    }

    public static void printWinner(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public static List<Car> makeCars(String[] carNames) {
        List<Car> Cars = new ArrayList<>();
        for (String carName : carNames) {
            Car tmpCar = new Car(carName);
            Cars.add(tmpCar);
        }
        return Cars;
    }
}
