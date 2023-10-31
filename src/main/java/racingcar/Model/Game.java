package racingcar.Model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> carList = new ArrayList<>();
    private int repetition;

    public Game(List<String> carNames){
        for(String carName: carNames){
            Car car = new Car(carName);
            carList.add(car);
        }
        repetition = 0;
    }

    public void setRepetition(int repetition){
        this.repetition = repetition;
    }
}
