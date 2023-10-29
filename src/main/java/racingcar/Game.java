package racingcar;

import java.util.Map;

public class Game {

    void start(){
        String[] cars = InputView.inputCars();
        int trialNumber = InputView.inputTrialNumber();
        Map<String, Integer> record = Racing.makeRecord(cars);

        for(int i=0; i < trialNumber; i++){
            OutputView.showRacingResult(Racing.recordResult(record));
            System.out.println();
        }

        OutputView.showWinner(Racing.decideWinner(record));
    }
}
