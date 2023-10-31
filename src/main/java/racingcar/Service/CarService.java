package racingcar.Service;

import static racingcar.Domain.RaceNumberGenerator.generateRandomNumber;
import static racingcar.Message.OutputMessage.CAR_DELIMITER;
import static racingcar.Message.OutputMessage.RACE_MARK;

import java.util.ArrayList;
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
        return RacingCars.create(carNames, this.generateRandomNumber);
    }

    public List<String> runRacing(RacingCars racingCars, RaceService raceService) {
        List<String> raceResults = new ArrayList<>();
        int currentRace = 0;
        while (!raceService.isRaceOver(currentRace)) {
            racingCars.race();
            raceResults.add(getRaceResult(racingCars.getCars()));
            currentRace++;
        }
        return raceResults;
    }

    private String getRaceResult(List<Car> cars) {
        StringBuilder raceResult = new StringBuilder();

        for (Car car : cars) {

            raceResult.append(car.getName()).append(CAR_DELIMITER).append(RACE_MARK.repeat(car.getPosition())).append("\n");
        }
        return raceResult.toString();
    }

    public static List<Car> stringToList(final String carNames) {
        String[] names = carNames.split(",");
        return Arrays.stream(names)
                .map(Car::create)
                .collect(Collectors.toList());
    }

    public List<Car> carList(RacingCars racingCars) {
        return racingCars.getCars();
    }

}
