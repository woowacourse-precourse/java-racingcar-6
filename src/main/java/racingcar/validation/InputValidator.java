package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.contant.GameNotice.DUPLICATE_CAR_NAME;
import static racingcar.contant.GameNotice.LENGTH_NOT_MATCH;
import static racingcar.contant.GameNotice.INPUT_ONLY_POSITIVE_NUMBER;
import static racingcar.contant.GameNotice.INPUT_ONLY_NUMBER;
import static racingcar.contant.GameNotice.NUM_OF_MIN_PARTICIPANT;
import static racingcar.contant.GameNotice.CONTAINS_GAP;
import static racingcar.contant.RacingCarGameConfig.CAR_NAME_MAX_LENGTH;
import static racingcar.contant.RacingCarGameConfig.PARTICIPANT_MIN_NUMBER;

public class InputValidator {
    InputValidator() {}

    public static void validateCarNameLength(String _carName) {
        if (!(_carName.length() <= CAR_NAME_MAX_LENGTH
                && !_carName.isEmpty())) {
            throw new IllegalArgumentException(String.valueOf(LENGTH_NOT_MATCH));
        }
    }

    public static void validateDuplicateCarName(List<String> _carNameList) {
        Set<String> carNameSet = new HashSet<String>(_carNameList);
        if (carNameSet.size() != _carNameList.size()) {
            throw new IllegalArgumentException(String.valueOf(DUPLICATE_CAR_NAME));
        }
    }

    public static void validateNumOfParticipantCar(List<String> _carNameList) {
        if (_carNameList.size() <= PARTICIPANT_MIN_NUMBER) {
            throw new IllegalArgumentException(String.valueOf(NUM_OF_MIN_PARTICIPANT));
        }
    }

    public static void validateContainsGap(List<String> _carNameList) {
        for (String _carName: _carNameList) {
            if (_carName.contains(" ")) throw new IllegalArgumentException(String.valueOf(CONTAINS_GAP));
        }
    }

    public static void validatePositiveNumber(int _roundNumber) {
        if (_roundNumber > 0) {
            throw new IllegalArgumentException(String.valueOf(INPUT_ONLY_POSITIVE_NUMBER));
        }
    }

    public static void validateTypeOfRoundNumber(String _roundNumber) {
        if (!_roundNumber.matches("[0-9]]+")) {
            throw new IllegalArgumentException(String.valueOf(INPUT_ONLY_NUMBER));
        }
    }
}
