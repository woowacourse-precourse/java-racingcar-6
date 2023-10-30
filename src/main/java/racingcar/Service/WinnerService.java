package racingcar.Service;

import java.util.List;
import racingcar.Domain.Car;
import racingcar.Domain.Winner;

public class WinnerService {
    public List<Car> getWinners(List<Car> cars) {
        // Winner 클래스를 활용하여 우승자 리스트를 반환
        return Winner.getWinners(cars);
    }
}