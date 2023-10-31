package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.StringTokenizer;

public class CarRacingManagement {
    public static void startRacing () {
        Commentator.printEnterCarName();
        String inputValue = Console.readLine();
        inputValue = inputValue.replaceAll(" ", "");
        StringTokenizer stringCarList = new StringTokenizer(inputValue, ",");
        int numberOfCars = stringCarList.countTokens();
        Car[] cars = new Car[numberOfCars];
        for (int carIndex = 0; carIndex < numberOfCars; carIndex++)
            cars[carIndex] = new Car(stringCarList.nextToken());

        Commentator.printEnterNumberOfAttempts();
        inputValue = Console.readLine();
        int numberOfAttempts = Integer.parseInt(inputValue);

        System.out.println("\n실행 결과");
        for (int count = 0; count < numberOfAttempts; count++) {
            updateAllCarPosition(cars);
            Commentator.printNowProgress(cars);
        }
        String winCarList = winnerCar(cars);
        Commentator.printWinner(winCarList);
    }
    private static void updateAllCarPosition (Car[] cars) {
        for (Car car : cars) {
            int randomDigit = Randoms.pickNumberInRange(0, 9);
            car.updatePosition(randomDigit);
        }
    }
    private static String winnerCar (Car[] cars) {
        String[] winnerList = getWinnerList(cars);
        String result = "";
        for (int winnerIndex = 0; winnerIndex < winnerList.length - 1; winnerIndex++)
            result += winnerList[winnerIndex] + ", ";
        result +=winnerList[winnerList.length - 1];
        return result;
    }
    private static String[] getWinnerList (Car[] cars) {
        int winnerPosition = Arrays.stream(cars)
                .mapToInt(car -> car.getCarPosition())
                .max()
                .orElse(1);
        return Arrays.stream(cars)
                .filter(car -> car.getCarPosition() == winnerPosition)
                .map(car -> car.getCarName())
                .toArray(String[]::new);
    }
}
