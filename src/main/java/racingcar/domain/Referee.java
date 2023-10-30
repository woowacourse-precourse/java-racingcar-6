package racingcar.domain;

import java.util.List;
import racingcar.util.Cars;

public class Referee {
    public void announcementWinners(List<Car> carList) {
        Cars cars = new Cars();
        System.out.println("최종 우승자 : " + cars.selectionWinners(carList));
    }
}
