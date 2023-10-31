package racingcar.engine;


import static racingcar.engine.RacingCarSystem.DRIVE_THRESHOLD;
import static racingcar.engine.RacingCarSystem.RANDOM_NUMBER_MAXIMUM_VALUE;
import static racingcar.engine.RacingCarSystem.RANDOM_NUMBER_MINIMUM_VALUE;
import static racingcar.engine.RacingCarSystem.TextMessage.EXECUTION_RESULT_PREFIX;
import static racingcar.engine.RacingCarSystem.TextMessage.OUTPUT_THE_WINNER_PREFIX;

import java.util.List;
import racingcar.common.Viewer;
import racingcar.engine.domain.Car;
import racingcar.engine.manager.Referee;
import racingcar.engine.mapper.RacingCarMapper;
import racingcar.utils.RandomUtils;
import racingcar.view.dto.RacingCarUserInputDto;

public class RacingCarGame {
    private final Viewer<RacingCarUserInputDto> viewer;
    private final Referee referee;
    private final RacingCarMapper racingCarMapper;

    public RacingCarGame(Viewer<RacingCarUserInputDto> viewer, Referee referee, RacingCarMapper racingCarMapper) {
        this.viewer = viewer;
        this.referee = referee;
        this.racingCarMapper = racingCarMapper;
    }

    public void start() {
        RacingCarUserInputDto userInputDto = viewer.interact();
        List<Car> cars = racingCarMapper.toCars(userInputDto.carNames());
        int numberOfAttempts = userInputDto.numberOfAttempts();

        viewer.println(EXECUTION_RESULT_PREFIX);
        while (numberOfAttempts-- > 0) {
            race(cars);
        }

        viewer.print(OUTPUT_THE_WINNER_PREFIX);
        showWinners(cars);
    }

    private void race(List<Car> cars) {
        cars.forEach((car) -> {
            int randomNumber = RandomUtils.getRandomNumber(
                    RANDOM_NUMBER_MINIMUM_VALUE.value(),
                    RANDOM_NUMBER_MAXIMUM_VALUE.value()
            );
            car.drive(DRIVE_THRESHOLD.value(), randomNumber);
        });
        String progressBar = racingCarMapper.toProgressBar(cars);
        viewer.println(() -> progressBar);
        viewer.printNewLine();
    }

    private void showWinners(List<Car> cars) {
        List<Car> winners = referee.decideWinners(cars);
        String winnerNames = racingCarMapper.toNames(winners);
        viewer.print(() -> winnerNames);
    }
}
