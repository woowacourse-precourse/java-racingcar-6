package controller;

import model.Cars;
import view.InputView;

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

    public void start(){
        try {
            //cars = new Cars(InputView.inputCarNames());
        } catch(IllegalArgumentException e){

        }
    }
}
