package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private User user;
    private List<Car> cars;
    Game(){
        cars = new ArrayList<>();
        play();
    }
    private void play(){


    }
    private void inputCars(List<String> carNames){
        carNames.stream().forEach(e->cars.add(new Car(e)));
    }
    private boolean checkPosition(int limitNumber,List<Car> cars){
        return cars
                .stream()
                .filter(e->e.getPosition()==limitNumber)
                .toList()
                .size()>1?true:false;
    }
}
