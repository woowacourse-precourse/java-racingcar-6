package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> cars = new ArrayList<>();

    public Game(){}

    public void addCar(String carNames){
        String[] strings = carNames.split(",");
        for (String carName:strings) {
            cars.add(new Car(carName));
        }
    }

    public String move(){
        String res="";
        for (Car car:cars) {
            car.move();
            res+= car.toString();
        }
        return res;
    }

    public String end(){
        String res="";
        boolean isFirst=true;
        int maxDistance=0;
        for(Car car:cars){
            if(car.getDistance()>maxDistance){
                maxDistance=car.getDistance();
            }
        }

        for(Car car:cars){
            if(car.getDistance()==maxDistance){
                if(isFirst){
                    res+=car.getName();
                    isFirst=false;
                }else{
                    res+=", ";
                    res+=car.getName();
                }
            }
        }
        return res;
    }
}
