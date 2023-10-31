package racingcar.domain;

import racingcar.input.Input;
import racingcar.input.InputParser;
import racingcar.input.InputValidator;
import racingcar.output.Output;


public class RacingCarGame {
    private final Output output;
    private final Input input;
    private final WinnerPicker winnerPicker;
    private Cars cars;

    public RacingCarGame(final Output output, final Input input, final WinnerPicker winnerPicker) {
        this.output = output;
        this.input = input;
        this.winnerPicker = winnerPicker;
    }

    public void play() {
        CarNames carNames = createCarNames(input.requestCarNames());
        RoundCount roundCount = createRoundCount(input.requestRoundCount());

        cars = new Cars(carNames);
        runRounds(cars, roundCount);

        pickAndPrintWinners();
    }

    private CarNames createCarNames(String carNamesInput) {
        InputValidator.validate(carNamesInput);
        return new CarNames(InputParser.parseCarNames(carNamesInput));
    }

    private RoundCount createRoundCount(String roundCountInput) {
        InputValidator.validate(roundCountInput);
        return new RoundCount(roundCountInput);
    }

    private void runRounds(Cars cars, RoundCount roundCount) {
        output.printEnter();
        output.print("실행결과");
        Round round = new Round(cars, new NumberGenerator(), new ForwardChecker());
        for (int i = 0; i < roundCount.getRoundCount(); i++) {
            round.run();
            output.print(cars);
            output.printEnter();
        }
    }

    private void pickAndPrintWinners() {
        Winners winner = winnerPicker.pickWinner(cars);
        output.print(winner);
    }
}
