package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.en.GameStatus;
import racingcar.util.InputView;
import racingcar.util.OutputView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class RacingGame {

    private GameStatus status;

    private List<RacingCar> racingCars;

    private int maxMoveValue;

    private int tryCount;

    public static RacingGame gameInit() {
        String racingCarStr = InputView.askRacingCarNames();
        int tryCount = InputView.askTryCount();

        return new RacingGame(racingCarStr, tryCount);
    }

    public RacingGame(String racingCarStr, int tryCount) {
        this.status = GameStatus.INIT;
        this.racingCars = convertStrToRacingCarList(racingCarStr);
        this.maxMoveValue = 0;
        this.tryCount = tryCount;
    }

    private List<RacingCar> convertStrToRacingCarList(String racingCarStr){
        String[] carNames = racingCarStr.split(",");
        List<RacingCar> carList = new ArrayList<>();
        for(String name: carNames) {
            RacingCar car = new RacingCar(name);
            carList.add(car);
        }
        return carList;
    }

    public void startGame() {
        this.status = GameStatus.RUNNING;
        while (this.tryCount != 0) {
            race();
            OutputView.printResult(this.racingCars);
        }
        printTotalResult();
    }

    public void printTotalResult() {
        List<String> winners = calTotalResult();
        OutputView.printTotalResult(winners);
    }


    public void stopGame() {
        this.status = GameStatus.FINISH;
    }
    private void race() {
        this.tryCount -= 1;

        for (RacingCar car : this.racingCars) {
            int move = Randoms.pickNumberInRange(0,9);
            if (move >= 4) {
                car.addMoveCnt();
            }
            if (this.maxMoveValue < car.getMoveCntInt()) {
                this.maxMoveValue = car.getMoveCntInt();
            }
        }

    }




    private List<String> calTotalResult() {
        List<String> winners = new ArrayList<>();

        for (RacingCar car : this.racingCars) {
            if (car.getMoveCntInt() == this.maxMoveValue) {
                winners.add(car.getName());
            }
        }
        return winners;
    }



}
