package racingcar.controller;

import racingcar.AppConfig;
import racingcar.domain.Car;
import racingcar.domain.RacingBoard;
import racingcar.service.Dice;
import racingcar.service.Judgement;
import racingcar.util.Divider;
import racingcar.util.WrongChecker;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameProgress {
    private RacingBoard racingBoard = new RacingBoard();
    private Input input = new Input();
    private Output output = new Output();

    int attemptCount = 0;

    public void startGame() {

        WrongChecker wrongChecker = new WrongChecker();
        Divider divider = new Divider();

        output.questionCarName();
        String inputStr = input.enterCarName();
        wrongChecker.hasWrongCarName(inputStr);
        racingBoard.joinManyCars(divider.doByComma(inputStr));

        output.questionAttemptNum();
        String inputNum = input.enterAttemptNum();
        wrongChecker.hasWrongAttemptNum(inputNum);
        attemptCount = Integer.parseInt(inputNum);

        input.inputClose();
    }

    public void doGame() {

        Judgement judgement = new AppConfig().judgement();

        output.printExecutionStart();

        while (true) {
            if (judgement.isGameSet(attemptCount)) {
                break;
            }
            turnProcess(racingBoard);
            attemptCount--;
        }

        racingBoard.recordWinner(judgement.judgeWinner(racingBoard));
    }

    public void finishGame() {
        output.printWinner(racingBoard);
    }

    public void turnProcess(RacingBoard racingBoard) {

        Dice dice = new AppConfig().dice();
        Judgement judgement = new AppConfig().judgement();

        for (Car car : racingBoard.view()) {
            int rollNum = dice.roll();
            if (judgement.checkGoCondition(rollNum)) {
                car.go();
            }
        }

        output.printExecution(racingBoard);
    }
}
