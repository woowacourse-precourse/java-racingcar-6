package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GameManager {

    List<Car> carList;

    public void gamePlay() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carList = CarFactory.createCars(UserInputReceiver.ReceiveCarNames(Console.readLine()));

        System.out.println("시도할 회수는 몇회인가요?");
        int tryTimes = UserInputReceiver.receiveTryTimes(Console.readLine());

        startForward(carList, tryTimes);

        String winnerNames = findWinnerNames(carList);
        System.out.println("최종 우승자 : " + winnerNames);
    }

    public String findWinnerNames(List<Car> carList) {

        StringJoiner winners = new StringJoiner(",");

        int maxScore = carList.stream()
                .mapToInt(Car::getForwardDistanceBetweenStartLine)
                .max()
                .orElse(0);

        carList.stream()
                .filter(car -> car.getForwardDistanceBetweenStartLine() == maxScore)
                .forEach(car -> winners.add(car.getName()));

        return winners.toString();
    }

    public void startForward(List<Car> cars, int tryTimes) {

        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < tryTimes; i++) {

            cars.forEach(car -> car.tryForwardByCondition(Randoms.pickNumberInRange(0, 9)));

            printCurrentLocation(cars);
        }

    }

    private static void printCurrentLocation(List<Car> cars) {
        cars.forEach(Car::locationInfoVisualizing);
        System.out.println();
    }

}
