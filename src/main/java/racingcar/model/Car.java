package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;
    private List<Integer> positions;

    public Car(String name) {
        this.name = name;
        this.positions = new ArrayList<>(List.of(0));
    }

    public static List<Car> createCars(String carNames){
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for(String name : names){
            cars.add(new Car(name));
        }
        return cars;
    }

    public int getLastPosition(){
        return positions.get(positions.size()-1);
    }

    public int getPosition(int index){
        return positions.get(index);
    }

    public String getName() {
        return name;
    }

    public void move(){
        positions.add(getLastPosition()+1);
    }

    public void pause(){
        positions.add(getLastPosition());
    }
}
