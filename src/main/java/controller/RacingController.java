package controller;

import model.Car;
import model.Cars;
import model.TryCount;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * packageName    : controller
 * fileName       : RacingController
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-30        qkrtn_ulqpbq2       최초 생성
 */
public class RacingController {

    private Cars cars;
    private TryCount tryCount;

    public void start(){
        cars = new Cars(InputView.inputCarNames());
        inputTryCount();
        race();
        result();
    }

    private void inputTryCount(){
        tryCount = new TryCount(InputView.inputTryCount());
    }


    private void race() {
        int nowTryCnt = 0;
        OutputView.printResultMessage();

        while(tryCount.isNotSame(nowTryCnt++)){
            cars.moveAll();
            OutputView.printCarsStatus(cars.getCars());
        }
    }

    private void result() {
        OutputView.printCarsStatus(cars.getCars());
        OutputView.printWinners(cars.getWinners());
    }
}
