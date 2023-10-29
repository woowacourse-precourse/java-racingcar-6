package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.OutputView.CAR_FORWARD_FLAG;

public class PlayRacing {

    static void forwardRecord(int tryNumber, List<Car> cars) {
        for (int i = 0; i < tryNumber; i++) {
            CarFuntion.forwardCar();
            System.out.print(Car.name + " : ");
            forwardFlag(Car.forwardNumber);
            System.out.println();
        }
    }

    static void selectWinner(List<Car> cars) {
        List<String> winnersList = new ArrayList<>();

        int maxForwardNumber = 0;
        for (Car car : cars) {
            if (car.forwardNumber > maxForwardNumber) {
                maxForwardNumber = car.forwardNumber;
            }
            if (car.forwardNumber == maxForwardNumber) {
                winnersList.add(car.name);
            }
        }
        String winners = String.join(", ", winnersList);
        System.out.println(winners);
    }

    static void forwardFlag(int forwardnumber) {
        for (int i = 0; i < forwardnumber; i++) {
            System.out.print(CAR_FORWARD_FLAG);
        }
    }
}
