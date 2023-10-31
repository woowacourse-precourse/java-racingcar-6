package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public String name;
    public int score;
    public Car(){
    }

    public Car(String name, int score){
        this.name=name;
        this.score=score;
    }

    public List<Car> createCars(List<String> carNames) {
        List<Car> Cars = new ArrayList<>();
        for(int i=0; i<carNames.size(); i++) {
            Cars.add(new Car(carNames.get(i), 0));
        }
        return Cars;
    }
}
