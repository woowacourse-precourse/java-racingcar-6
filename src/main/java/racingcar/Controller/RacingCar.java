package racingcar.Controller;

import racingcar.Model.Cars;
import racingcar.Util.Compare;
import racingcar.Util.Winner;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racingcar.Model.RacingCarRandomNumber.RacingCarRandomNumbers;

public class RacingCar {
    private List<String> carList = new ArrayList<>();
    private List<Integer> carListRandomCount = new ArrayList<>();
    private List<Integer> location;
    private List<String> winnerList = new ArrayList<>();
    private int raceTries;

    public void racingStart() {
        playerJoin();
    }

    private void playerJoin() {
        carList = Cars.split(InputView.getCarName());
        raceTries = InputView.setRaceAttempts();
        OutputView.setTryResult();
        location = new ArrayList<>(Collections.nCopies(carList.size(), 0));
        playRacing();
    }

    private void playRacing() {
        for (int i = 0; i < raceTries; i++) {
            carListRandomCount = RacingCarRandomNumbers(carList.size());
            OutputView.moveForward(carList, carListRandomCount);
            System.out.println();
            location = Compare.number(carListRandomCount, location);
        }
        RacingWinner();
    }


    private void RacingWinner() {
        winnerList = Winner.carList(carList, location);
        OutputView.result(winnerList);
    }
}
