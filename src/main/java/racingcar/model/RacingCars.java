package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<RacingCar> getRacingWinners() {
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
                .orElse(-1);        // 리팩토링 : 예외처리 클래스로
    }
    public List<String> listRacingCarToListString(List<RacingCar> racingCars) {
        return racingCars
                .stream()
                .map(RacingCar::getRacingCarName)
                .collect(Collectors.toList());
    }
}
