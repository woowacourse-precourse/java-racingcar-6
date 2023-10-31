package racingcar.controller;

import racingcar.model.ForwardChecker;
import racingcar.model.Participant;
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
        printWinners();
    }

    private void playRound() {
        for(Participant participant : rankingBoard.getRankingBoard()){
            if(forwardChecker.isForward()){
                rankingBoard.plus(participant.getName());
            }
        }
    }

    public void printRoundResult(){
        for (Participant participant : rankingBoard.getRankingBoard()){
            String carName = participant.getName();
            Integer forwardNumber = participant.getStepOfForward();
            Printer.printRoundResult(carName, forwardNumber);
        }
        Printer.printWhiteSpace();
    }

    public void printWinners(){
        Printer.printWinner(rankingBoard.getWinners());
    }
}
