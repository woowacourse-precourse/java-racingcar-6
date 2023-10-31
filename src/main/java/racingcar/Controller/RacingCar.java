package racingcar.Controller;

import racingcar.domain.CarList;
import racingcar.Service.CarName;
import racingcar.Service.MoveORStop;
import racingcar.Util.Winner;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    private List<CarList> racingCarList = new ArrayList<>();
    private List<String> carNameList = new ArrayList<>();
    private List<String> winnerList = new ArrayList<>();
    private int raceTry;

    public void racingStart() {
        playerJoin();
    }

    private void playerJoin() {
        carNameList = CarName.split(InputView.getCarName());
        for (String carName : carNameList) {
            racingCarList.add(new CarList(carName));
        }
        playRacing();
    }

    private void playRacing() {
        raceTry = InputView.RaceCount();
        OutputView.setTryMessage();

        for (int i = 0; i < raceTry; i++) {
            RacingRandomNumberIsMoveORStop();
            System.out.println();
        }
        RacingWinner();
    }

    private void RacingWinner() {
        winnerList = Winner.carList(racingCarList);
        OutputView.result(winnerList);
    }

    private void RacingRandomNumberIsMoveORStop() {
        for (CarList car : racingCarList) {
            MoveORStop.RacingCar(car);
        }
    }


}
