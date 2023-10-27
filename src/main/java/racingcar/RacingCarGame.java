package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingCarGame {
    InputProcessor inputProcessor;
    OutputProcessor outputProcessor;
    GameBoard gameBoard;
    Integer repetition;

    public RacingCarGame() {
        inputProcessor = new InputProcessor();
        outputProcessor = new OutputProcessor();
    }

    public void run() {
        initializeGame();

        for (int repetitionCount = 0; repetitionCount < repetition; repetitionCount++) {
            gameBoard.processTurn();
            outputProcessor.printMoveResult(gameBoard.getCopyOfPlayerList());
        }

        outputProcessor.printWinners(gameBoard.findWinners());
    }

    private void initializeGame() {
        outputProcessor.printCarNameInputMessage();
        this.gameBoard = new GameBoard(inputProcessor.readCarNamesInput());
        outputProcessor.printRepetitionInputMessage();
        this.repetition = inputProcessor.readRepetitionInput();
    }
}
