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

        System.out.println();
        System.out.println("실행결과");
        for (int i = 0; i < racingCount; i++) {
            playRacing(carList);
        }
        getAndPrintWinners(carList);
    }

    private static List<Car> inputAndGetCarList() {
        String carNames = inputCarNames();
        return getCarList(carNames);
    }

    private static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 김표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static List<Car> getCarList(String carNames) {
        List<Car> carList = new ArrayList<>();
        String[] carNameArray = carNames.split(",");

        for (String carName : carNameArray) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("5자 이하 이름만 가능");
            }

            if (carName.length() == 0) {
                continue;
            }

            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    private static int inputRacingCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String racingCount = Console.readLine();

        try {
            return Integer.parseInt(racingCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값이 입력됨");
        }
    }

    private static void playRacing(List<Car> carList) {
        for (Car car : carList) {
            car.playRacing();
        }
        System.out.println();
    }

    private static void getAndPrintWinners(List<Car> carList) {
        List<String> winnerList = getWinnerList(carList);
        printWinners(winnerList);
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

    private static void printWinners(List<String> winnerList) {
        int listSize = winnerList.size();

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < listSize-1; i++) {
            System.out.print(winnerList.get(i) + ", ");
        }
        System.out.println(winnerList.get(listSize - 1));
    }
}
