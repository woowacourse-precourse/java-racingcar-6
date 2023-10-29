package racingcar.controller;

import racingcar.model.ForwardChecker;
import racingcar.model.RankingBoard;
import racingcar.model.TryNumber;
import racingcar.view.Printer;

import java.util.Map;

public class RacingCarGame {
    private final InputDevice inputDevice = new InputDevice();
    private final ForwardChecker forwardChecker = new ForwardChecker();

    private RankingBoard rankingBoard;
    private TryNumber tryNumber;

    public void run() {
        Printer.printQuestionCars();
        rankingBoard = new RankingBoard(inputDevice.inputCarNames());

        Printer.printQuestionTryNumber();
        tryNumber = new TryNumber(inputDevice.inputTryNumber());

        Printer.printWhiteSpace();
        Printer.printResultStart();

        for (int round = 0; round < tryNumber.getTryNumber(); round++) {
            playRound();
            printRoundResult();
        }
    }

    private void playRound() {
        for(String carName : rankingBoard.getCarNames()){
            if(forwardChecker.isForward()){
                rankingBoard.plus(carName);
            }
        }
    }

    public void printRoundResult(){
        for (Map.Entry<String, Integer> entry : rankingBoard.getRankingBoard().entrySet()){
            String carName = entry.getKey();
            Integer forwardNumber = entry.getValue();
            Printer.printRoundResult(carName, forwardNumber);
        }
        Printer.printWhiteSpace();
    }
}
