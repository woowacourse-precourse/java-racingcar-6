package racingcar;

import racingcar.domain.Car;
import racingcar.exception.InputException;
import racingcar.util.GameUtil;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GameUtil gameUtil = new GameUtil();
        InputException inputException = new InputException();

        String cars = inputView.inputCars();
        ArrayList<Car> carList = gameUtil.splitNameArrayList(cars); // 이름을 쉼표(,) 기준으로 나눠 리스트로 만듬
        inputException.nameLengthOver(carList);
        inputException.sameName(carList);

        int number = inputView.inputCount();

        outputView.gameResult();

        for(int i=0;i<number;i++){
            outputView.gameSituation(carList); // 게임 진행 상황
            gameUtil.goAndStop(carList); // 자동차 가는지 멈추는지

            System.out.println();
        }

        int max = gameUtil.winnerLocation(carList); // 우승자 위치
        String winner = gameUtil.winner(carList, max);
        outputView.winner(winner);
    }
}