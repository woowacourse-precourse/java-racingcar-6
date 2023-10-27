package racingcar.Controller;

import racingcar.Model.Cars;
import racingcar.Util.Compare;
import racingcar.Util.WinnerCarList;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racingcar.Model.RacingCarRandomNumber.RacingCarRandomNumbers;

public class RacingCar {
    private List<String> carList = new ArrayList<>();
    private List<Integer> carListRandomCount = new ArrayList<>();
    private List<Integer> goAndStop;
    private List<String> winnerList = new ArrayList<>();
    private int raceTries;

    public void racingStart() {
        RacingCar(carList, carListRandomCount);
    }

    private void RacingCar(List<String> carList, List<Integer> carListRandomCount) {
        carList = Cars.carSplit(InputView.getCarName());
        raceTries = InputView.setRaceAttempts();
        goAndStop = new ArrayList<>(Collections.nCopies(carList.size(), 0));
        OutputView.setTryResult();
        for (int i = 0; i < raceTries; i++) {
            carListRandomCount = RacingCarRandomNumbers(carList.size());
            OutputView.carGo(carList, carListRandomCount);
            System.out.println();
            goAndStop = Compare.numberCompare(carListRandomCount, goAndStop);
        }
        winnerList = WinnerCarList.winnerCarList(carList, goAndStop);
        OutputView.result(winnerList);
    }
}
