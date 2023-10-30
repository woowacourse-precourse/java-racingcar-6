package racingcar.Service;

import java.util.List;
import racingcar.Domain.Car;
import racingcar.Domain.Winner;

public class WinnerService {
    CarService carService = new CarService();
    public List<Car> getWinners() {
        // Winner 클래스를 활용하여 우승자 리스트를 반환
        return Winner.getWinners(carService.carList());
    }
}