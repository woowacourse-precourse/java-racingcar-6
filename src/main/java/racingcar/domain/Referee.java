package racingcar.domain;

import java.util.List;
import racingcar.util.Cars;

public class Referee {
    private static final String WINNERS = "최종 우승자 : ";

    public void announcementWinners(List<Car> carList) {
        Cars cars = new Cars();
        System.out.println(WINNERS + cars.selectionWinners(carList));
    }
}
