package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Inputs inputs;

    List<Car> selectWinner(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int maxGoNumber = 0;
        for (Car car : cars) {
            // 경주 자동차들의 최대 전진 회수를 체크
            maxGoNumber = checkMaxGoNumber(car, maxGoNumber, winners);
        }
        return winners;
    }

    private int checkMaxGoNumber(Car car, int maxGoNumber, List<Car> winners) {
        if (car.totalGoNumber > maxGoNumber) { // 현재 자동차의 전진 회수 > 기존 최고 전진 회수
            maxGoNumber = car.totalGoNumber; // 기존 최고 전진 회수 업데이트
            winners.clear(); // 기존 우승자 목록 초기화
            winners.add(car); // 우승자 목록에 현재 자동차 추가
        } else if (car.totalGoNumber == maxGoNumber) { // 현재 자동차의 전진 회수 == 기존 최고 전진 회수
            winners.add(car); // 우승자 목록에 현재 자동차 추가
        }
        return maxGoNumber;
    }

    public void printResult(List<Car> cars) {
        for (int i = 0; i < inputs.raceNumbers; i++) {
            printResultByRound(cars, i);
        }
    }

    private void printResultByRound(List<Car> cars, int turn) {
        for (Car car : cars) {
            System.out.printf("%s : ", car.carName);
            System.out.print(car.result[turn]);
        }
    }

}
