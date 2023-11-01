package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.exception.DuplicatedCarException;
import racingcar.exception.NonNullCarNameException;
import racingcar.exception.UnderCarNameLengthException;
import racingcar.exception.UnderCarMinNumException;

public class RaceParticipants {
    private final Set<RacingCar> participantCars;
    private static final int MIN_PARTICIPANTCARS = 2;

    public RaceParticipants(List<String> nameList) {
        validateCarName(nameList);
        this.participantCars = nameList.stream().map(RacingCar::new).collect(Collectors.toSet());
    }

    private void validateCarName(List<String> nameList) {
        checkNameNotNull(nameList);
        checkOverMinSize(nameList);
        checkLengthLimit(nameList);
        checkDuplicated(nameList);
    }

    private void checkNameNotNull(List<String> nameList) {
        if (nameList.stream().anyMatch(String::isEmpty)) {
            throw new NonNullCarNameException();
        }
    }

    private void checkDuplicated(List<String> nameList) {
        Set<String> uniqueNames = new HashSet<>(nameList);
        if (uniqueNames.size() < nameList.size()) {
            throw new DuplicatedCarException();
        }
    }

    private void checkLengthLimit(List<String> nameList) {
        if (nameList.stream().anyMatch(name -> name.length() > 5)) {
            throw new UnderCarNameLengthException();
        }

    }

    private void checkOverMinSize(List<String> nameList) {
        if(nameList.size() < MIN_PARTICIPANTCARS){
            throw new UnderCarMinNumException();
        }
    }
    public List<String> getRacingStatus() {
        return participantCars.stream().map(RacingCar::toString).toList();
    }

    public List<String> getWinner() {
        int farthestLocation = getMaxLocation();
        return participantCars.stream()
                .filter(car -> car.getLocation() == farthestLocation)
                .map(RacingCar::getName)
                .toList();
    }

    private int getMaxLocation() {
        return participantCars.stream()
                .mapToInt(RacingCar::getLocation)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }


    public Set<RacingCar> getParticipantCars() {
        return participantCars;
    }
}
