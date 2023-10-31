package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.AppConfig;
import racingcar.domain.Car;
import racingcar.domain.RacingBoard;
import racingcar.service.Dice;
import racingcar.service.Judgement;
import racingcar.service.impl.RandomDiceImpl;
import racingcar.util.Divider;
import racingcar.util.WrongChecker;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameProgress {
    private RacingBoard racingBoard = new RacingBoard();
    private Dice dice = new AppConfig().dice();
    private Judgement judgement = new AppConfig().judgement();
    private Divider divider = new Divider();
    private WrongChecker wrongChecker = new WrongChecker();
    private Input input = new Input();
    private Output output = new Output();

    int attemptCount = 0;

    public void startGame() {

        String inputStr;
        String inputNum;
        ArrayList<String> carNameArrayList;

        //자동차 이름 플레이어 입력 및 자동차 등록
        output.questionCarName();
        inputStr = input.enterCarName();
        wrongChecker.hasWrongCarName(inputStr);
        for (String s : divider.doByComma(inputStr)) {
            Car car;
            racingBoard.join(car = new Car(s));
        }
        //시도 횟수 사용자 입력 및 등록
        output.questionAttemptNum();
        inputNum = input.enterAttemptNum();
        wrongChecker.hasWrongAttemptNum(inputNum);
        attemptCount = Integer.parseInt(inputNum);

        input.inputClose();
    }

    public void doGame() {
        output.printExecutionStart();
        while(!(judgement.isGameSet(attemptCount))) {
            for(Car car : racingBoard.view()) {
                int rollNum = dice.roll();
                if(judgement.checkGoCondition(rollNum)) {
                    car.go();
                }
            }
            output.printExecution(racingBoard);

            attemptCount--;
        }
        racingBoard.recordWinner(judgement.judgeWinner(racingBoard));
    }

    public void finishGame() {
        output.printWinner(racingBoard);
    }
}
