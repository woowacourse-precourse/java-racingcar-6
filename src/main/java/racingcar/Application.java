package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        startRacing();
    }

    private static void startRacing() {
        List<Car> carList = inputAndGetCarList();
        int racingCount = inputRacingCount();

        System.out.println("실행결과");
        for (int i = 0; i < racingCount; i++) {
            playRacing(carList);
        }
    }

    private static List<Car> inputAndGetCarList() {
        String carNames = inputCarNames();
        return getCarList(carNames);
    }

    private static String inputCarNames() {
        System.out.println("\"경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static List<Car> getCarList(String carNames) {
        List<Car> carList = new ArrayList<>();
        String[] carNameArray = carNames.split(",");

        for (String carName : carNameArray) {
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    private static int inputRacingCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String racingCount = Console.readLine();
        return Integer.parseInt(racingCount);
    }

    private static void playRacing(List<Car> carList) {
        for (Car car : carList) {
            int randomNumber = getRandomNumber();
            updateMovingCountOrNot(car, randomNumber);
            car.printResult();
        }
        System.out.println();
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private static void updateMovingCountOrNot(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.addOneMovingCount();
        }
    }
}
