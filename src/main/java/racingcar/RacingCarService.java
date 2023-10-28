package racingcar;

import java.util.List;

public class RacingCarService {

    private final CarNameSeperator carNameSeperator;

    private List<Car> cars;

    public RacingCarService(final CarNameSeperator carNameSeperator) {
        this.carNameSeperator = carNameSeperator;
    }

    public void saveCarName(final String input) {
        List<String> seperatedCarNames = carNameSeperator.seperateCarNames(input);
        seperatedCarNames.stream()
                .map(Car::new)
                .forEach(cars::add);
    }

}
