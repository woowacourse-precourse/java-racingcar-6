package racingcar.engine;


import static racingcar.engine.RacingCarSystem.ATTEMPTS_MAXIMUM_VALUE;
import static racingcar.engine.RacingCarSystem.CAR_NAME_SEPARATOR;
import static racingcar.engine.RacingCarSystem.DRIVE_THRESHOLD;
import static racingcar.engine.RacingCarSystem.Input.ATTEMPTS_MINIMUM_VALUE;
import static racingcar.engine.RacingCarSystem.Input.CAR_NAME_MAXIMUM_LENGTH;
import static racingcar.engine.RacingCarSystem.Input.CAR_NAME_MINIMUM_LENGTH;
import static racingcar.engine.RacingCarSystem.RANDOM_NUMBER_MAXIMUM_VALUE;
import static racingcar.engine.RacingCarSystem.RANDOM_NUMBER_MINIMUM_VALUE;
import static racingcar.engine.RacingCarSystem.TextMessage.EXECUTION_RESULT_PREFIX;
import static racingcar.engine.RacingCarSystem.TextMessage.INPUT_THE_CAR_NAMES;
import static racingcar.engine.RacingCarSystem.TextMessage.INPUT_THE_NUMBER_OF_ATTEMPTS;
import static racingcar.engine.RacingCarSystem.TextMessage.OUTPUT_THE_WINNER_PREFIX;

import java.util.Arrays;
import java.util.List;
import racingcar.common.Prompt;
import racingcar.common.Validator;
import racingcar.engine.domain.Car;
import racingcar.engine.manager.Referee;
import racingcar.engine.mapper.RacingCarMapper;
import racingcar.utils.RandomUtils;

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

        List<Car> cars = racingCarMapper.toCar(CAR_NAME_SEPARATOR.value(), carNames);
        int verifiedNumberOfAttempts = racingCarMapper.toInteger(numberOfAttempts);
        prompt.printNewLine();

        prompt.println(EXECUTION_RESULT_PREFIX);
        while (verifiedNumberOfAttempts-- > 0) {
            cars.forEach((car) -> {
                int randomNumber = RandomUtils.getRandomNumber(
                        RANDOM_NUMBER_MINIMUM_VALUE.value(),
                        RANDOM_NUMBER_MAXIMUM_VALUE.value()
                );
                car.drive(DRIVE_THRESHOLD.value(), randomNumber);
            });
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
