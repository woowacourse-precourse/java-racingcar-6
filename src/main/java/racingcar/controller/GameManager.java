package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GameManager {
    public void checkMovePossible(Car car){
        int random = createRandomNumber();
        if(random >= 4){
            car.move();
        }
    }

    private int createRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public void selectWinner(List<Car> cars){
        Collections.sort(cars, Collections.reverseOrder());
        int maxDistance = cars.get(0).getDistance();
        String output = MassageManager.FINAL_WINNER + cars.get(0).getName();

        for (int i = 1; i<cars.size(); i++){
            if (maxDistance == cars.get(i).getDistance()){
                output += ", " + cars.get(i).getName();
            }else{
                break;
            }
        }
        System.out.println(output);
    }
}
