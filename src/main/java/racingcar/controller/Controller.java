package racingcar.controller;

import racingcar.function.CheckName;
import racingcar.value.Value;
import racingcar.view.InputView;
import racingcar.function.CheckNumber;
import racingcar.function.GoStopRule;
import racingcar.view.OutputView;
import java.util.ArrayList;
import java.util.List;


public class Controller {
    private final Value values;
    private final GoStopRule goStopRule;
    private final OutputView outputView;

    public Controller() {
        this.values = new Value();
        this.goStopRule = new GoStopRule();
        this.outputView = new OutputView();

    }

    public void run() {
        carName();
        raceAttempts();
//        gameStart();
        initGame();
        gameStart();
    }

    private void carName() {
        String inputNames = InputView.inputCarNames();
        CheckName.validate(inputNames);
        values.addCarNames(inputNames.split(","));
    }

    private void raceAttempts() {
        String input = InputView.inputNumberOfAttempts();
        int numberOfAttempts = CheckNumber.validate(input);
        values.setNumberOfAttempts(numberOfAttempts);
    }

    private void initGame(){
        int numberOfCars = values.getCarNames().size();
        values.initializeCarPositions(numberOfCars);
    }

    private void gameStart(){
        int roundOfGame = values.getNumberOfAttempts();
        for (int round = 0; round < roundOfGame; round++){
            playRound();
        }
    }

    private void playRound() {
        List<Integer> carPositions = values.getCarPositions();
        for (int i = 0; i < carPositions.size(); i++) {
            goStop(i);
        }
    }
    private void goStop(int carIndex) {
        if (goStopRule.shouldGo()) {
            int newPosition = values.getCarPositions().get(carIndex) + 1;
            values.updateCarPositions(carIndex, newPosition);
        }
    }




}
//    private void gameStart() {
//        int roundOfGame = values.getNumberOfAttempts();
//        List<Integer> carPositions = new ArrayList<>();         // 처리 완료.
//
//        for (int i = 0; i < values.getCarNames().size(); i++) { // 처리 완료
//            carPositions.add(0);                                // 처리 완료
//        }                                                       // 처리 완료
//
//        for (int round = 0; round < roundOfGame; round++) { //   처리 완료
//            playRound(carPositions);
//            outputView.printRoundResult(values.getCarNames(), carPositions);
//        }
//        values.determineWinners(carPositions);
//        outputView.printWinners(values.getWinners());
//    }
//    private void playRound(List<Integer> carPositions) {               처
//        for (int i = 0; i < carPositions.size(); i++) {                리
//            if (goStopRule.shouldGo()) {                               완
//                carPositions.set(i, carPositions.get(i) + 1);          료
//            }
//        }
//    }
//}