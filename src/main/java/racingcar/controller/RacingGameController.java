package racingcar.controller;

import java.util.List;
import racingcar.controller.mapper.AttemptMapper;
import racingcar.controller.mapper.CarNameMapper;
import racingcar.model.RacingGame;
import racingcar.model.vo.Attempt;
import racingcar.model.vo.CarName;
import racingcar.validation.AttemptValidator;
import racingcar.validation.NameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private NameValidator nameValidator;
    private CarNameMapper carNameMapper;
    private AttemptValidator attemptValidator;
    private AttemptMapper attemptMapper;
    private InputView inputView;
    private OutputView outputView;

    public RacingGameController() {
        this.nameValidator = new NameValidator();
        this.carNameMapper = new CarNameMapper();
        this.attemptValidator = new AttemptValidator();
        this.attemptMapper = new AttemptMapper();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        // input car name event
        String carNames = inputView.inputCarNames();
        RacingGame game = makeCar(carNames);

        // input attempt event
        String attempts = inputView.inputAttempts();
        Attempt attempt = setAttempts(attempts);

        // start event
        outputView.printResultMessage();
        String result = game.playGame(attempt);
        outputView.printGameResult(result);

        // print winner
        String winner = determineWinner(game);
        outputView.printGameWinner(winner);
    }

    public RacingGame makeCar(String carNames) {
        // validate has comma
        nameValidator.validate(carNames);
        // convert String to CarName
        List<CarName> carNameGroup = carNameMapper.toCarName(carNames);
        // validate
        nameValidator.validate(carNameGroup);
        // init game (make cars)
        RacingGame game = new RacingGame();
        game.init(carNameGroup);
        return game;
    }

    public Attempt setAttempts(String attemptStr) {
        // validate
        attemptValidator.validate(attemptStr);
        // convert String to Attempt
        Attempt attempt = attemptMapper.toAttempt(attemptStr);
        // save attempts
        return attempt;
    }

    public String determineWinner(RacingGame game) {
        // determine winner
        return game.determineWinner();
    }
}
