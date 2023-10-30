package racingcar.domain;

import static racingcar.contants.RacingGameConstants.RANDOM_MAX_VALUE;
import static racingcar.contants.RacingGameConstants.RANDOM_MIN_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.contants.RacingGameConstants;

public class ParticipantCars {
    private List<Car> participantCars;

    public ParticipantCars() {
    }

    public ParticipantCars(String carNamesString) {
        this.participantCars = Arrays.stream(carNamesString.split(RacingGameConstants.DELIMITER))
                .map(carNameString -> new Car(carNameString))
                .collect(Collectors.toList());
    }

    public List<Car> getParticipantCars() {
        return Collections.unmodifiableList(participantCars);
    }

    public void moveCars() {
        participantCars.forEach(
                car -> car.moveAccordingToInput(Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE)));
    }

    public Integer getMaxMovingCount(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getMovingCount())
                .max(Integer::compareTo)
                .orElseThrow();
    }

    public List<String> getWinners(List<Car> cars) {
        return Collections.unmodifiableList(cars.stream()
                .filter(car -> car.getMovingCount() == getMaxMovingCount(cars))
                .map(car -> car.getName())
                .collect(Collectors.toList()));
    }
}
