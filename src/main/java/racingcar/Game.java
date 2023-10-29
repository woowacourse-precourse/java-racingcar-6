package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.InputView;

public class Game {

    private int tryCount;
    private List<Car> carList;

    public void run(){
        String[] car = InputView.readCarName();
        tryCount = InputView.readTryCount();

        generateCar(car);
    }

    public void generateCar(String[] car){
        carList = new ArrayList<>();

        for(String name: car){
            carList.add(new Car(name));
        }
    }
}
