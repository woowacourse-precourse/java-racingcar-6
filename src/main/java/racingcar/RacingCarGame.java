package racingcar;


import static racingcar.RacingCarSystem.ATTEMPTS_MAXIMUM_VALUE;
import static racingcar.RacingCarSystem.CAR_NAME_SEPARATOR;
import static racingcar.RacingCarSystem.Input.ATTEMPTS_MINIMUM_VALUE;
import static racingcar.RacingCarSystem.Input.CAR_NAME_MAXIMUM_LENGTH;
import static racingcar.RacingCarSystem.Input.CAR_NAME_MINIMUM_LENGTH;
import static racingcar.RacingCarSystem.TextMessage.EXECUTION_RESULT_PREFIX;
import static racingcar.RacingCarSystem.TextMessage.INPUT_THE_CAR_NAMES;
import static racingcar.RacingCarSystem.TextMessage.INPUT_THE_NUMBER_OF_ATTEMPTS;
import static racingcar.RacingCarSystem.TextMessage.OUTPUT_THE_WINNER_PREFIX;

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
        // input 받을때 출력 문구도 한번에 받아보쟝
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
        // todo: 캐시 가능 한번 지표 한번 가보자고!
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
                    validator.verifyInRangeClosed(
                            CAR_NAME_MINIMUM_LENGTH.getValue(),
                            CAR_NAME_MAXIMUM_LENGTH.getValue(),
                            carName.length());
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
