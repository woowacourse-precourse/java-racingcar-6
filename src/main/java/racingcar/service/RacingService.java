package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarManager;
import racingcar.domain.RaceRule;
import racingcar.domain.TryInput;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingService {

    private final RaceRule raceRule;
    private CarManager carManager;
    private TryInput tryInput;

    public RacingService(RaceRule raceRule) {
        this.raceRule = raceRule;
    }

    public void generateCar(List<String> nameList) {
        List<Car> cars = nameList.stream()
                .map(Car::createCar)
                .collect(Collectors.toList());

        this.carManager = new CarManager(cars);
    }

    public List<String> playRace(String tryInput) {
        inputTryCount(tryInput);

        int tryCount = this.tryInput.getTryCount();

        return IntStream.range(0, tryCount)
                .mapToObj(i -> carManager.moveCar(raceRule))
                .collect(Collectors.toList());
    }

    public String getWinner() {
        String winners = carManager.getWinner();

        return winners;
    }

    private void inputTryCount(String tryInput) {
        this.tryInput = new TryInput(tryInput);
    }

}
