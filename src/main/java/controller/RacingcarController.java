package controller;

import domain.CarService;
import mapper.CarMapper;
import view.InputView;
import view.OutputView;

public class RacingcarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarMapper carMapper = new CarMapper(new CarService());

    public RacingcarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        setCars();
        setRound();
        printRunResult();
    }

    private void setCars() {
        outputView.inputCarName();
        carMapper.setCars(inputView.carName());
    }

    private void setRound() {
        outputView.inputRoundNumber();
        carMapper.setRound(inputView.roundNumber());
    }

    private void printRunResult() {
        outputView.outputRunResult();
    }

    public void playRound() {
        carMapper.playRound();
        outputView.outputCarPosition(carMapper.getState());
    }

    public boolean isEnd() {
        return carMapper.isEnd();
    }

    public void endGame() {
        outputView.outputFinalWinner(carMapper.decideWinner());
    }
}
