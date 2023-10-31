package racingcar;

import camp.nextstep.edu.missionutils.Console;
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
    }
}
