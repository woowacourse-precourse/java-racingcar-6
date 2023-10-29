package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.List;

public class CarMove {
    public static boolean moveCheck(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
    public static void move(List<Car> car_list){
        for (int i = 0; i<car_list.size(); i++){
            if (moveCheck()){
                car_list.get(i).addMove();
            }
        }
    }
}
