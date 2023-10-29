package racingcar.domain;

import java.util.List;
import racingcar.util.Cars;

public class Referee {
    Cars cars = new Cars();
    public void announcementWinners(List<Car> carList) {
        System.out.println("최종 우승자 : " + cars.selectionWinners(carList));
    }
}
