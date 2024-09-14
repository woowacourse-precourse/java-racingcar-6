package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> cars;


    public Cars(String msg){
        this.cars = new ArrayList<>();
        makeCars(splitMsg(msg));
    }




    public List<String> splitMsg(String msg){
        return  Arrays.asList(msg.split(","));
    }

    public void makeCars(List<String> msgs){
        for(String msg : msgs){
            Car car = new Car(msg.trim());
            cars.add(car);
        }
    }

    public void moveCars(){
        for(Car car : cars){
            if(Randoms.pickNumberInRange(0,9) >=4){
                car.movePosition();
            }
        }
    }

    public List<Car> getCars(){
        return  cars;
    }

    public List<Car> getWinner(){
        int max = 0;
        for(Car car: cars){
            if(car.getPositionInt() > max){
                max = car.getPositionInt();
            }
        }
        List<Car> winnerCars = new ArrayList<>();
        for(Car car: cars){
            if(car.getPositionInt() ==max){
                winnerCars.add(car);
            }
        }
        return winnerCars;
    }
}
