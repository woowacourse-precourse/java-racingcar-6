package racingcar.domain;

import java.util.List;
import racingcar.dto.CarDTO;
import racingcar.vo.Cars;
import racingcar.vo.RoundCount;

public class Racing {
    private final Cars cars;
    private final RoundCount roundCount;
    private int curRound = 0;

    public Racing(List<Car> carList, RoundCount roundCount) {
        this.roundCount = roundCount;
        this.cars = new Cars(carList);
    }

    public List<CarDTO> round() {
        cars.moveAll();
        curRound++;
        return cars.toDTO();
    }

    public boolean isEnd() {
        return curRound == roundCount.getCount();
    }

    public List<CarDTO> getWinner() {
        return cars.getMaxPositionCars();
    }
}