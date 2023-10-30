package racingcar.Service;

import static racingcar.Domain.RaceNumberGenerator.generateRandomNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Domain.Car;
import racingcar.Domain.Race;
import racingcar.Domain.RacingCars;

public class CarService {
    RaceService raceService = new RaceService();
    RacingCars racingCars;
    public void inputCarNames(String carNames) {
        racingCars = RacingCars.create(carNames);
    }

    public void runRacing(){
        int currentRace = 0;
        while (!raceService.isRaceOver(currentRace)) {
            racingCars.race();
            currentRace++;
        }
    }

    public static List<Car> stringToList(final String carNames) {
        String[] names = carNames.split(",");
        return Arrays.stream(names)
                .map(Car::create)
                .collect(Collectors.toList());
    }

}
