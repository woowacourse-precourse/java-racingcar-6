package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.attempt.Attempt;
import racingcar.domain.cars.Players;
import racingcar.domain.cars.Winners;
import racingcar.domain.racingcargame.RacingCarGame;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;
import racingcar.view.output.dto.RacingStateDto;
import racingcar.view.output.dto.WinnersDto;

public class RacingCarGameController {

    private static final String COMMA = ",";

    public void play() {
        Players players = createPlayers();
        Attempt attempt = comfirmAttempt();
        RacingCarGame game = new RacingCarGame(players, attempt);
        printResultMessage();
        race(game);
        judgeWinners(game);
    }

    private Players createPlayers() {
        String names = InputView.nameInput();
        List<String> carNames = Arrays.stream(names.split(COMMA))
            .collect(Collectors.toList());
        return Players.of(carNames);
    }

    private Attempt comfirmAttempt() {
        int attemptValue = InputView.attemptInput();
        return new Attempt(attemptValue);
    }

    private void printResultMessage() {
        OutputView.printResultMessage();
    }

    private void race(RacingCarGame game) {
        while (game.hasNext()) {
            game.race();
            OutputView.printRacingState(RacingStateDto.from(game.players()));
        }
    }

    private void judgeWinners(RacingCarGame game) {
        Winners winners = game.winners();
        OutputView.printWinners(WinnersDto.from(winners));
    }
}
