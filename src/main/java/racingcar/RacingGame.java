package racingcar;

import java.util.ArrayList;
import java.util.List;
import Car.Car;

public class RacingGame {
    public static void printWinner(List<Car> carList) {
        List<String> winnerNameList = new ArrayList<>();

        int maxCurrentLocation = 0;

        for (Car car : carList) {
            if (car.getCurrentLocation() > maxCurrentLocation) {
                maxCurrentLocation = car.getCurrentLocation();
            }
        }

        for (Car car : carList) {
            if (car.getCurrentLocation() == maxCurrentLocation) {
                winnerNameList.add(car.getName());
            }
        }

        System.out.print("최종 우승자 : ");
        String winnerNames = String.join(",", winnerNameList);
        System.out.println(winnerNames);
    }

    public static void startGame(List<Car> carList, String userInputRepeatCount){
        Validator.validateRepeatCount(userInputRepeatCount);
        int repeatCount = Integer.parseInt(userInputRepeatCount);

        for (int i = 0; i < repeatCount; i++) {
            for (Car car : carList) {
                car.moveForwardOrStay();
                car.printCurrentLocation();
            }
            System.out.println();
        }
    }
}
