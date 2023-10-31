package racingcar.Controller;

import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {



    public void start(){
        Cars cars = new Cars(InputView.inputName());
        TryCount tryCount =  new TryCount(InputView.inputCnt());
        int cnt =Integer.parseInt(tryCount.getTryCount());
        race(cars,cnt);

    }

    public void race(Cars cars,int tryCount){
        for (int i=0;i<tryCount;i++){
            cars.move();
            OutputView.carsStatus(cars.getCars());
        }


    }

}
