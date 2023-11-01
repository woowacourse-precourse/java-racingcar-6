package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class RaceingCar {

    public static ArrayList<Car> cars;

    public void racingCar(ArrayList<Car> cars){
        this.cars = cars;
    }
    public void race(){
        racingCar(cars);
        for(Car car : cars){
            int randomNum = Randoms.pickNumberInRange(0,9);
            if(randomNum >= 4){
                car.moving();
            }
        }
    }

    public ArrayList<Car> winner(){
        ArrayList<Car> win = new ArrayList<>();
        int top = Integer.MIN_VALUE;
        for(Car car : cars){
            int score = car.getMove();
            if(score > top){
                win.clear();
                win.add(car);
                top = score;
            }else{
                win.add(car);
            }
        }
        return win;
    }
}
