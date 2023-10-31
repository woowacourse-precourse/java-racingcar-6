package racingcar.Service;

import static racingcar.Domain.RaceNumberGenerator.generateRandomNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.Domain.Car;
import racingcar.Domain.Race;
import racingcar.Domain.RaceNumberGenerator;
import racingcar.Domain.RacingCars;

public class CarService {
    RaceNumberGenerator generateRandomNumber = new RaceNumberGenerator();
    public RacingCars inputCarNames(final String carNames) {
        return RacingCars.create(carNames,this.generateRandomNumber);
    }

    public void runRacing(RacingCars racingCars, RaceService raceService){
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

    public List<Car> carList(RacingCars racingCars){
        return racingCars.getCars();
    }

}
