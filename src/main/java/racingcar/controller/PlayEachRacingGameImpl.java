package racingcar.controller;

import racingcar.model.Car;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

public class PlayEachRacingGameImpl implements PlayEachRacingGame{

    OutputView outputView = new OutputView();
    public List<Car> getPlayEachRacingGame(List<Car> cars) {
        Car car;

        for(int i=0;i<cars.size();i++){
            car=cars.get(i);
            if(isMoving()){
                car.move();
                cars.set(i,car);
            }
            outputView.printEachCarResult(car.getName(),car.getMoveCount());
        }

        outputView.printLineSpace();

        return cars;
    }

    private boolean isMoving(){
        int num=Randoms.pickNumberInRange(0,9);
        if(num>=4){
            return true;
        }
        else{
            return false;
        }
    }
}
