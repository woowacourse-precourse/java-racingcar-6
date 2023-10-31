package racingcar.Controller;

import racingcar.model.Cars;
import racingcar.view.InputView;

public class RacingController {



    public void start(){
        Cars cars = new Cars(InputView.inputName());
        int tryCount =Integer.parseInt(InputView.inputCnt());
        race(cars,tryCount);

    }

    public void race(Cars cars,int tryCount){
        for (int i=0;i<tryCount;i++){
            cars.move();
        }


    }

}
