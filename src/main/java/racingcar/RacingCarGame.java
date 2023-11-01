package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.domain.RacingCar;
import racingcar.view.InputDevice;
import racingcar.view.OutputDevice;

public class RacingCarGame implements Game {

    @Override
    public void play() {
        List<String> names = InputDevice.inputNamesWithCommaDelimiter();
        int attemptCount = InputDevice.inputAttemptCount();

        RacingCar racingCar = new RacingCar(names);
        playRacingGame(racingCar, attemptCount);
    }

    private void playRacingGame(RacingCar racingCar, int attemptCount) {
        String resultMessage = getRacingGameActionResultMessage(racingCar, attemptCount);
        OutputDevice.printResultMessage(resultMessage);

        String winnerMessage = racingCar.getWinnerMessage();
        OutputDevice.printWinnerMessage(winnerMessage);
    }

    private String getRacingGameActionResultMessage(RacingCar racingCar, int attemptCount) {
        return IntStream.rangeClosed(1, attemptCount)
                .mapToObj(i -> {
                    racingCar.playRacing();
                    return racingCar.getResultMessage();
                })
                .collect(Collectors.joining("\n\n"));
    }

}
