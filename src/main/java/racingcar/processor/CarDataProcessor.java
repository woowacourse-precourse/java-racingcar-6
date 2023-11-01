package racingcar.processor;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Name;
import racingcar.game.GameRound;

public class CarDataProcessor {

    private static final String SEPARATOR = ",";
    private final Request request;

    public CarDataProcessor(Request request) {
        this.request = request;
    }

    public List<Car> process() {
        String carNames = request.inputCarName();
        return saveCars(carNames);
    }

    public GameRound processCount() {
        int gameRounds = request.inputGameCount();
        return new GameRound(gameRounds);
    }

    public List<Car> saveCars(String inputCars) {
        List<String> carNames = Arrays.stream(inputCars.split(SEPARATOR))
                .toList();
        return carNames.stream()
                .map(carName -> new Car(new Name(carName)))
                .toList();
    }
}
