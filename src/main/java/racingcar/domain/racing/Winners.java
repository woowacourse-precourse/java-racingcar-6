package racingcar.domain.racing;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.racing.car.Car;

/**
 * 우승자들의 목록을 관리하는 일급 컬렉션입니다.
 */
public class Winners {

    private List<Car> winners = new ArrayList<>();

    private Winners() {

    }

    public static Winners createEmpty() {
        return new Winners();
    }

    public void addWinner(Car car) {
        winners.add(car);
    }

    public List<Car> getWinners() {
        return winners;
    }
}
