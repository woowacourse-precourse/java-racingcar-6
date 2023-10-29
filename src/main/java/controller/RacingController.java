package controller;

import model.Cars;
import model.TryCount;
import view.InputView;
import view.OutputView;

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
        try {
            cars = new Cars(InputView.inputCarNames());
            inputTryCount();
            race();
        } catch(IllegalArgumentException e){
            OutputView.printException(e);
        }
    }

    private void inputTryCount(){
        try {
            tryCount = new TryCount(InputView.inputTryCount());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            inputTryCount();
        }
    }


    private void race() {
        int nowTryCnt = 0;
        OutputView.printResultMessage();

//        while(tryCount.isNotSame(nowTryCnt++)){
//            cars.moveAll();
//        }
    }
}
