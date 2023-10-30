package racingcar;


import static racingcar.SystemMessage.EXECUTION_RESULT_PREFIX;
import static racingcar.SystemMessage.INPUT_THE_CAR_NAMES;
import static racingcar.SystemMessage.INPUT_THE_NUMBER_OF_ATTEMPTS;
import static racingcar.SystemMessage.OUTPUT_THE_WINNER_PREFIX;
import static racingcar.SystemPolicy.ATTEMPTS_MAXIMUM_VALUE;
import static racingcar.SystemPolicy.CAR_NAME_SEPARATOR;
import static racingcar.SystemPolicy.Input.ATTEMPTS_MINIMUM_VALUE;
import static racingcar.SystemPolicy.Input.CAR_NAME_MAXIMUM_LENGTH;
import static racingcar.SystemPolicy.Input.CAR_NAME_MINIMUM_LENGTH;

import java.util.Arrays;
import java.util.List;

public class RacingCarGame {
    private final Prompt prompt;
    private final Validator validator;
    private final Referee referee;
    private final RacingCarMapper racingCarMapper;

    public RacingCarGame(Prompt prompt, Validator validator, Referee referee, RacingCarMapper racingCarMapper) {
        this.prompt = prompt;
        this.validator = validator;
        this.referee = referee;
        this.racingCarMapper = racingCarMapper;
    }

    public void start() {
        prompt.println(INPUT_THE_CAR_NAMES);
        String carNames = prompt.input();
        verifyCarNames(carNames);

        prompt.println(INPUT_THE_NUMBER_OF_ATTEMPTS);
        String numberOfAttempts = prompt.input();
        verifyNumberOfAttempts(numberOfAttempts);

        List<Car> cars = racingCarMapper.toCar(CAR_NAME_SEPARATOR.getValue(), carNames);
        int verifiedNumberOfAttempts = racingCarMapper.toInteger(numberOfAttempts);
        prompt.printNewLine();

        prompt.println(EXECUTION_RESULT_PREFIX);
        while (verifiedNumberOfAttempts-- > 0) {
            cars.forEach(Car::moveForward);
            String progressBar = racingCarMapper.toProgressBar(cars);
            prompt.println(() -> progressBar);
            prompt.printNewLine();
        }

        prompt.print(OUTPUT_THE_WINNER_PREFIX);
        List<Car> winners = referee.getWinner(cars);
        String winnerNames = racingCarMapper.toNames(winners);
        prompt.print(() -> winnerNames);
    }


    private void verifyCarNames(String participants) {
        Arrays.stream(participants.split(CAR_NAME_SEPARATOR.getValue()))
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
                ATTEMPTS_MAXIMUM_VALUE.getValue(),
                verifiedNumber);
    }
}
