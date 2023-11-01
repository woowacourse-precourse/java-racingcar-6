package racingcar;

import java.util.ArrayList;
import java.util.List;

public class StopAndGo {

    InputRacingCar racingCar = new InputRacingCar();
    InputRacingNumber racingNumber = new InputRacingNumber();

    void stopAndGo() {
        List<String> racingCarList = racingCar.inputRacingCar();
        int number = racingNumber.inputRacingNumber();

        int racingCarSize = racingCarList.size();
        List<Integer> racingCarScore = new ArrayList<>();

        for (int i = 0; i < racingCarSize; i++) {
            racingCarScore.add(0);
        }

        SaveStopAndGo save = new SaveStopAndGo();
        PrintStopAndGo print = new PrintStopAndGo();

        for (int i = 0; i < number; i++) {
            save.saveStopAndGo(racingCarScore);
            print.printStopAndGo(racingCarList, racingCarScore);
            System.out.println();
        }

        JudgeWinner winner = new JudgeWinner();
        winner.judgeWinner(racingCarList, racingCarScore);
    }
}