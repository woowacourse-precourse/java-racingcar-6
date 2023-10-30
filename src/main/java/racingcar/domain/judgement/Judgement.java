package racingcar.domain.judgement;

import java.util.List;
import racingcar.domain.car.Car;

public interface Judgement {
        void announcementWinner(List<Car> carList);
}
