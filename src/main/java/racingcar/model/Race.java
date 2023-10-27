package racingcar.model;

import java.util.ArrayList;

public class Race {
    private final ArrayList<String> carNameList;
    private final int round;
    private final  ArrayList<Car> carList = new ArrayList<>();

    public Race(ArrayList<String> carNameList, int round){
        this.carNameList = carNameList;
        this.round = round;
        convertToCar();
    }

    public void convertToCar(){
        carNameList.forEach(carName -> carList.add(new Car(carName)));
    }
}
