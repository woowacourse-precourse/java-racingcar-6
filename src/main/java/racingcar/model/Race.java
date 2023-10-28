package racingcar.model;

import java.util.ArrayList;

public class Race {
    private final int round;
    private final ArrayList<String> carNameList;
    private final  ArrayList<Car> carList = new ArrayList<>();

    public Race(ArrayList<String> carNameList, int round){
        this.carNameList = carNameList;
        this.round = round;
        convertToCar();
    }

    public void convertToCar(){
        carNameList.forEach(carName -> carList.add(new Car(carName)));
    }

    public void start() {
        for (int i = 0; i < round; i++) {
            carList.forEach(Car::go);
        }
    }

    public ArrayList<Car> getCarList(){
        return this.carList;
    }
}
