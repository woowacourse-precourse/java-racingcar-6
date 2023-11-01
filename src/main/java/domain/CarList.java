package domain;

import java.util.ArrayList;
import java.util.Collections;

public class CarList {
    private final ArrayList<Car> cars= new ArrayList<>();

    public CarList(String [] cars)
    {
        for (String car: cars){
            this.cars.add(new Car(car));
        }
    }

    public ArrayList<Car> turnGoOrStay(){
        for(Car car: cars)
        {
            car.go();
        }
        return cars;
    }


    public String[] getWinnerNames(){
        int maxPosition= ArrayMax(getCarsPositions());
        return cars.stream().map(car -> car.getPosition()==maxPosition).toArray(String[]::new);
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
