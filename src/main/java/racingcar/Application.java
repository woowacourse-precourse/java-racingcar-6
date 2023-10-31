package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
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
        printWinners(carList);
    }

    private static List<Car> inputAndGetCarList() {
        String carNames = inputCarNames();
        return getCarList(carNames);
    }

    private static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
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

    private static void printWinners(List<Car> carList) {
        List<String> winnerList = getWinnerList(carList);
        int listSize = winnerList.size();

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < listSize-1; i++) {
            System.out.print(winnerList.get(i) + ", ");
        }
        System.out.println(winnerList.get(listSize - 1));
    }

    private static List<String> getWinnerList(List<Car> carList) {
        List<String> winnerList = new ArrayList<>();
        int maxCount = getMaxCount(carList);

        for (Car car : carList) {
            String name = car.getName();
            int movingCount = car.getMovingCount();

            if (movingCount == maxCount) {
                winnerList.add(name);
                continue;
            }

            if (movingCount < maxCount) {
                break;
            }
        }
        return winnerList;
    }

    private static int getMaxCount(List<Car> carList) {
        carList.sort(Collections.reverseOrder());
        Car maxCountCar = carList.get(0);
        return maxCountCar.getMovingCount();
    }
}
