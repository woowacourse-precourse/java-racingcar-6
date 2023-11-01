package racingcar.model;

import racingcar.dto.output.ResultOfGameDto;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.dto.output.ResultOfGameDto.createWinnersOfGame;

public class RacingCars {
    private final List<RacingCar> racingCars;

    private RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }
    public static RacingCars from(List<RacingCar> racingCars) {
        return new RacingCars(racingCars);
    }
    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
    public ResultOfGameDto getWinners() {
        List<RacingCar> cars = getMostAdvancedRacingCar();
        List<String> winners = converListRacingCarToListString(cars);
        ResultOfGameDto resultOfGameDto = createWinnersOfGame(winners);
        return resultOfGameDto;
    }
    public List<RacingCar> getMostAdvancedRacingCar() {
        List<RacingCar> cars = racingCars;
        Integer maxAdvanceMarkingLength = findMaxAdvanceMarkingLength(cars);
        return cars.stream()
                .filter(car -> car.getAdvanceMarking().length() == maxAdvanceMarkingLength)
                .collect(Collectors.toList());
    }
    private Integer findMaxAdvanceMarkingLength(List<RacingCar> cars) {
        return cars.stream()
                .mapToInt(car -> car.getAdvanceMarking().length())
                .max()
                .orElse(-1);
    }
    public List<String> converListRacingCarToListString(List<RacingCar> racingCars) {
        return racingCars
                .stream()
                .map(RacingCar::getRacingCarName)
                .collect(Collectors.toList());
    }
}
