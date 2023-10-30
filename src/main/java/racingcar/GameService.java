package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.CarsService.updateCount;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class GameService {
    private static final String ErrorMessage = "0보다 큰 숫자를 입력해주세요.";
    public static final int MOVING_FORWARD_STANDARD_NUMBER = 4;

    public GameService() {
    }

    public void playGame() {
        Map<Car, Integer> cars = CarsService.makeCars(getUserInputForCars());
        int numberOfMatches = getUserInputForNumberOfMatches();
        System.out.println();
        ResultService.printResultStart();
        ResultService.printResultsPerGame(cars, numberOfMatches);
        ResultService.printWinners(ResultService.decideWinners(cars));
    }

    public static String getUserInputForCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    public static int getUserInputForNumberOfMatches() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int number = Integer.parseInt(readLine());
            return validateNumber(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage);
        }
    }

    private static int validateNumber(int number) {
        if (number > 0) {
            return number;
        }
        throw new IllegalArgumentException(ErrorMessage);
    }

    public static int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean movingForwardCheck(int randomNumber) {
        if (randomNumber >= MOVING_FORWARD_STANDARD_NUMBER) {
            return true;
        }
        return false;
    }

    public static Map<Car, Integer> recordNumberOfMovingForward(Map<Car, Integer> cars, Car car,
                                                                boolean isMovingForward) {
        if (isMovingForward) {
            cars.replace(car, updateCount(cars, car));
        }
        return cars;
    }
}
