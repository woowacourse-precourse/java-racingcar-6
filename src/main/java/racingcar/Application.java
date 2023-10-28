package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> carNamesList = inputCarNamesByUser();
        int attemptNum = getAttemptNumber();

        List<Car> cars = createCarObject(carNamesList);
        for (int i = 0; i < attemptNum; i++) {
            race(cars);
        }

        List<String> winnerList = calculateWinner(cars);
    }

    private static List<String> inputCarNamesByUser() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();
        String[] inputArray = input.split(",");

        List<String> carNameList = new ArrayList<>();
        for (String carName : inputArray) {
            carNameList.add(carName);
        }
        return carNameList;
    }

    private static int getAttemptNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        int inputNumber = Integer.parseInt(Console.readLine());
        return inputNumber;
    }

    private static List<Car> createCarObject(List<String> carNamesList) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNamesList) {
            cars.add(new Car(carName));
        }
        return cars;
    }
    private static void race(List<Car> cars) {
        for (Car car : cars) {
            int moveNum = generateRandomNumber();
            if (canMove(moveNum)) {
                car.move();
            }
        }
        showCurrentPosition(cars);
    }

    private static int generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }

    private static boolean canMove(int generateNumber) {
        if (generateNumber < 4) {
            return false;
        }
        return true;
    }
    private static void showCurrentPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + ":" + car.getPostringToString());
        }
        System.out.println();
    }

    private static List<String> calculateWinner(List<Car> cars) {
        int maxPostion = calculateMaxPosition(cars);

        List<String> winnerList = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPostion) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    private static int calculateMaxPosition(List<Car> cars) {
        int maxPostion = 0;
        for (Car car : cars) {
            maxPostion = Math.max(maxPostion, car.getPosition());
        }
        return maxPostion;
    }

}
