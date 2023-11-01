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

    public ParticipantCars(List<Car> participantCars) {
        this.participantCars = participantCars;
    }

    public static ParticipantCars createParticipantCars(String carNamesString) {
        List<Car> participantCars = Arrays.stream(carNamesString.split(RacingGameConstants.DELIMITER))
                .map(carNameString -> new Car(carNameString))
                .collect(Collectors.toList());

        return new ParticipantCars(participantCars);
    }

    public List<Car> getParticipantCars() {
        return Collections.unmodifiableList(participantCars);
    }

    public void moveCars() {
        participantCars.forEach(
                car -> car.moveAccordingToInput(Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE)));
    }

    public int getMaxMovingCount() {
        return participantCars.stream()
                .map(participantCar -> participantCar.getMovingCount())
                .max(Integer::compareTo)
                .orElseThrow();
    }

    public List<String> getWinners() {
        return Collections.unmodifiableList(participantCars.stream()
                .filter(participantCar -> participantCar.getMovingCount() == getMaxMovingCount())
                .map(car -> car.getName())
                .collect(Collectors.toList()));
    }
}
