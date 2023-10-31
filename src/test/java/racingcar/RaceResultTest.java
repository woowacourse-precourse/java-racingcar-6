package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceResultTest {
    @Test
    void 우승자_찾기_테스트() {
        // Car 객체 생성
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Car1"));
        cars.add(new Car("Car2"));
        cars.add(new Car("Car3"));

        // 각 Car의 위치 설정
        cars.get(0).move(2); // Car1의 위치: 2
        cars.get(1).move(1); // Car2의 위치: 1
        cars.get(2).move(3); // Car3의 위치: 3

        // 우승자 찾기
        int maxPosition = findMaxPosition(cars);

        // 우승자 이름 찾기
        List<String> winners = findWinners(cars, maxPosition);

        // 우승자 이름 확인
        assertThat(winners).contains("Car3");
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            int position = car.getPosition();
            maxPosition = Math.max(maxPosition, position);
        }
        return maxPosition;
    }

    private List<String> findWinners(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
