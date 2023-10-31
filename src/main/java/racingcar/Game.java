package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {


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

}
