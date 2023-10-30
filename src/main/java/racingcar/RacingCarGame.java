package racingcar;


import static racingcar.SystemMessage.EXECUTION_RESULT_PREFIX;
import static racingcar.SystemMessage.INPUT_THE_CAR_NAMES;
import static racingcar.SystemMessage.INPUT_THE_NUMBER_OF_ATTEMPTS;
import static racingcar.SystemMessage.OUTPUT_THE_WINNER_PREFIX;
import static racingcar.SystemPolicy.Input.ATTEMPTS_MINIMUM_VALUE;
import static racingcar.SystemPolicy.Input.CAR_NAME_MAXIMUM_LENGTH;
import static racingcar.SystemPolicy.Input.CAR_NAME_MINIMUM_LENGTH;

import java.util.Arrays;

public class RacingCarGame {
    private final Prompt prompt;
    private final Validator validator;
    private final RacingCarMapper racingCarMapper;

    public RacingCarGame(Prompt prompt, Validator validator, RacingCarMapper racingCarMapper) {
        this.prompt = prompt;
        this.validator = validator;
        this.racingCarMapper = racingCarMapper;
    }

    public void start() {
        prompt.println(INPUT_THE_CAR_NAMES);
        String participants = prompt.input();
        verifyCarNames(participants);

        prompt.println(INPUT_THE_NUMBER_OF_ATTEMPTS);
        String numberOfAttempts = prompt.input();
        verifyNumberOfAttempts(numberOfAttempts);
        int verifiedNumberOfAttempts = racingCarMapper.toInteger(numberOfAttempts);
        prompt.printNewLine();

        prompt.println(EXECUTION_RESULT_PREFIX);
        while (verifiedNumberOfAttempts-- > 0) {
            prompt.println(() -> "실행 과정 출력하기");
            prompt.printNewLine();
        }

        prompt.print(OUTPUT_THE_WINNER_PREFIX);
        String winners = "pobi, jun";
        prompt.print(() -> winners);
    }

    private void verifyCarNames(String participants) {
        Arrays.stream(participants.split(","))
                .forEach(carName -> {
                    validator.verifyNullAndBlank(carName);
                    validator.verifyLength(
                            CAR_NAME_MINIMUM_LENGTH.getValue(),
                            CAR_NAME_MAXIMUM_LENGTH.getValue(),
                            carName);
                });
    }


    public void verifyNumberOfAttempts(String numberOfAttempts) {
        validator.verifyNullAndBlank(numberOfAttempts);
        validator.verifyDigitPerUnit(numberOfAttempts);
        int verifiedNumber = racingCarMapper.toInteger(numberOfAttempts);
        validator.verifyInRangeClosed(
                ATTEMPTS_MINIMUM_VALUE.getValue(),
                ATTEMPTS_MINIMUM_VALUE.getValue(),
                verifiedNumber);
    }
}
