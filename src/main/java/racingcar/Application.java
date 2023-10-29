package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Racing;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Racing race1 = Racing.createRacingWithInput();
        race1.startRacing();
        List<String> winners = race1.getWinners()
                .stream().map(Car::getName).toList();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
