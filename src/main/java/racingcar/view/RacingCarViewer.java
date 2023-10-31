package racingcar.view;

import static racingcar.engine.RacingCarSystem.ATTEMPTS_MAXIMUM_VALUE;
import static racingcar.engine.RacingCarSystem.ATTEMPTS_MINIMUM_VALUE;
import static racingcar.engine.RacingCarSystem.CAR_NAME_MAXIMUM_LENGTH;
import static racingcar.engine.RacingCarSystem.CAR_NAME_MINIMUM_LENGTH;
import static racingcar.engine.RacingCarSystem.CAR_NAME_SEPARATOR;
import static racingcar.engine.RacingCarSystem.TextMessage.INPUT_THE_CAR_NAMES;
import static racingcar.engine.RacingCarSystem.TextMessage.INPUT_THE_NUMBER_OF_ATTEMPTS;

import java.util.Arrays;
import java.util.List;
import racingcar.common.Validator;
import racingcar.common.Viewer;
import racingcar.view.dto.RacingCarUserInputDto;

public class RacingCarViewer extends Viewer<RacingCarUserInputDto> {
    private final Validator validator;
    private final RacingCarViewerMapper racingCarMapper;

    public RacingCarViewer(Validator validator, RacingCarViewerMapper racingCarMapper) {
        this.validator = validator;
        this.racingCarMapper = racingCarMapper;
    }

    @Override
    public RacingCarUserInputDto interact() {
        String carNamesInput = input(INPUT_THE_CAR_NAMES);
        verifyCarNames(carNamesInput);

        String numberOfAttemptsInput = input(INPUT_THE_NUMBER_OF_ATTEMPTS);
        verifyNumberOfAttempts(numberOfAttemptsInput);
        printNewLine();

        List<String> carNames = racingCarMapper.toCarNames(CAR_NAME_SEPARATOR.value(), carNamesInput);
        int numberOfAttempts = racingCarMapper.toInteger(numberOfAttemptsInput);
        var inputDto = racingCarMapper.toRacingCarUserInputDto(carNames, numberOfAttempts);

        return inputDto;
    }

    private void verifyCarNames(String participants) {
        Arrays.stream(participants.split(CAR_NAME_SEPARATOR.value()))
                .forEach(carName -> {
                    validator.verifyNullAndBlank(carName);
                    validator.verifyInRangeClosed(
                            CAR_NAME_MINIMUM_LENGTH.value(),
                            CAR_NAME_MAXIMUM_LENGTH.value(),
                            carName.length());
                });
    }

    public void verifyNumberOfAttempts(String numberOfAttempts) {
        validator.verifyNullAndBlank(numberOfAttempts);
        validator.verifyDigitPerUnit(numberOfAttempts);
        int verifiedNumber = racingCarMapper.toInteger(numberOfAttempts);
        validator.verifyInRangeClosed(
                ATTEMPTS_MINIMUM_VALUE.value(),
                ATTEMPTS_MAXIMUM_VALUE.value(),
                verifiedNumber);
    }
}
