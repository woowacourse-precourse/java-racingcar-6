package racingcar.getWinners;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.CarImpl;
import racingcar.race.RaceImpl;

public class GetWinnersImpl implements GetWinners{

    private RaceImpl race;
    private List<CarImpl> cars;

    public GetWinnersImpl(RaceImpl race) {
        this.race = race;
        this.cars = new ArrayList<>(race.getCars());
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(car -> car.toString().split(" : ")[0])
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(CarImpl::getPosition)
                .max()
                .orElse(0);
    }
}
