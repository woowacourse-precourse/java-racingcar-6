package racingcar.domain;

import racingcar.input.Input;
import racingcar.input.InputParser;
import racingcar.input.InputValidator;
import racingcar.output.Output;


public class RacingCarGame {
    private Output output;
    private Input input;
    private WinnerPicker winnerPicker;

    public RacingCarGame(Output output, Input input, WinnerPicker winnerPicker) {
        this.output = output;
        this.input = input;
        this.winnerPicker = winnerPicker;
    }

    public void play() {

        String carNamesInput = input.requestCarNames();
        InputValidator.validate(carNamesInput);
        CarNames carNames = new CarNames(InputParser.parseCarNames(carNamesInput));
        Cars cars = new Cars(carNames);

        String roundCountInput = input.requestRoundCount();
        InputValidator.validate(roundCountInput);
        RoundCount roundCount = new RoundCount(roundCountInput);

        output.printEnter();
        output.print("실행결과");
        Round round = new Round(cars, new NumberGenerator(), new ForwardChecker());
        for (int i = 0; i < roundCount.getRoundCount(); i++) {
            round.run();
            output.print(cars);
            output.printEnter();
        }
        Winners winner = winnerPicker.pickWinner(cars);
        output.print(winner);
    }
}
