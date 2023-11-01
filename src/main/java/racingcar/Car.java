package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private final StringBuilder run = new StringBuilder();
    public Car(String name){
        this.name = name;
    }
    private static final List<Car> carsList = new ArrayList<>();
    public String getName() {
        return name;
    }
    public int getDistance(){
        return run.length();
    }
    public void addRun(){
        run.append("-");
    }
    public String toString(){
        return name + " : " + run;
    }
    public static List<Car> generateCars(List<String> carNames) {
        for (String name : carNames) {
            carsList.add(new Car(name));
        }
        return carsList;
    }
}
