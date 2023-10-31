package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class CarList {
    private final ArrayList<Car> cars= new ArrayList<>();

    public CarList(ArrayList<String> cars)
    {
        for (String car: cars){
            this.cars.add(new Car(car));
        }
    }

    public void turnGoOrStay(){
        for(Car car: cars)
        {
            car.go();
        }
    }

    public HashMap<String, Integer> getTurnPositions() {
        HashMap<String, Integer> turnResult = new HashMap<>();
        for(Car car : cars){
            turnResult.put(car.getName(), car.getPosition());
        }
        return turnResult;

    }

    public String[] getWinnerNames(){
        int maxPosition= ArrayMax(getCarsPositions());
        return (String[])cars.stream().map(car -> car.getPosition()==maxPosition).toArray();
    }

    private ArrayList<Integer> getCarsPositions(){
        ArrayList<Integer> positionArray = new ArrayList<>();
        for(Car car : cars){
            positionArray.add(car.getPosition());
        }
        return positionArray;
    }

    private static int ArrayMax(ArrayList<Integer> positions){
        return Collections.max(positions);

    }
}
