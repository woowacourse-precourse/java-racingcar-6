package controller;

import domain.CarService;
import domain.RemainingRound;
import mapper.CarMapper;
import view.InputView;
import view.OutputView;

public class RacingcarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarMapper carMapper = new CarMapper(new CarService());

    private RemainingRound remainingRound = new RemainingRound();

    public RacingcarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        outputView.inputCarName();
        carMapper.setCars(inputView.carName());
        outputView.inputRoundNumber();
        remainingRound.set(inputView.roundNumber());
        outputView.outputRunResult();
    }

    public void playRound() {
        remainingRound.playRound();
        carMapper.playRound();
        outputView.outputCarPosition(carMapper.getState());
    }

    public boolean isEnd() {
        return remainingRound.isEnd();
    }

    public void endGame() {
        outputView.outputFinalWinner(carMapper.decideWinner());
    }
}
