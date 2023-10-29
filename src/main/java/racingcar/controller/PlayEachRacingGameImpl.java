package racingcar.controller;

import racingcar.model.Car;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class PlayEachRacingGameImpl implements PlayEachRacingGame{

    public List<Car> getPlayEachRacingGame(List<Car> cars) {
        Car car;
        for(int i=0;i<cars.size();i++){
            if(isMoving()){
                car=cars.get(i);
                car.move();
                cars.set(i,car);
            }
        }

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
