package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.StringTokenizer;

public class CarRacingManagement {
    public static void startRacing () {
        String inputValue = Console.readLine();
        inputValue = inputValue.replaceAll(" ", "");
        StringTokenizer stringCarList = new StringTokenizer(inputValue, ",");
        int numberOfCars = stringCarList.countTokens();
        Car[] cars = new Car[numberOfCars];
        for (int carIndex = 0; carIndex < numberOfCars; carIndex++)
            cars[carIndex] = new Car(stringCarList.nextToken());

        inputValue = Console.readLine();
        int numberOfAttempts = Integer.parseInt(inputValue);
        for (int count = 0; count < numberOfAttempts; count++) {
            updateAllCarPosition(cars);
            Commentator.printNowProgress(cars);
        }
    }
    private static void updateAllCarPosition (Car[] cars) {
        for (Car car : cars) {
            int randomDigit = Randoms.pickNumberInRange(0, 9);
            car.updatePosition(randomDigit);
        }
    }
}
