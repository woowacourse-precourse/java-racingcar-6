package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import racingcar.domain.generator.NumberGenerator;
import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class RaceParticipants {
    private final List<RacingCar> racingCarList = new ArrayList<>();

    public RaceParticipants(String carNames, NumberGenerator numberGenerator) {
        List<String> carNamesList = splitCarNames(carNames);
        validateCarNameNotEmpty(carNamesList);
        validateCarNameDuplicate(carNamesList);
        carNamesList.forEach(name -> racingCarList.add(new RacingCar(name, numberGenerator)));
    }

    private List<String> splitCarNames(String carNames) {
        String[] carNamesArray = carNames.split(",", -1);
        return Arrays.stream(carNamesArray).map(String::trim).toList();
    }

    private void validateCarNameNotEmpty(List<String> carNames) {
        if (carNames.stream().anyMatch(String::isEmpty)) {
            throw new InvalidInputException(ErrorMessage.CAR_NAMES_NOT_EMPTY);
        }
    }

    private void validateCarNameDuplicate(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new InvalidInputException(ErrorMessage.CAR_NAME_DUPLICATE);
        }
    }

    public List<RacingCar> getRacingCarList() {
        return Collections.unmodifiableList(racingCarList);
    }
}
