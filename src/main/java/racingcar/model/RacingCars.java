package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class RacingCars {
    private final ArrayList<Car> CARS = new ArrayList<>();

    public RacingCars(ArrayList<String> cars){
        cars.forEach(car->CARS.add(new Car(car)));
    }

    public void roundGo(){
        for(Car car:CARS){
            car.go();
        }
    }

    public HashMap<String,Integer> getRoundResult(){
        HashMap<String,Integer> roundResult = new HashMap<>();
        for(Car car:CARS){
            roundResult.put(car.getName(),car.getPosition());
        }
        return roundResult;
    }

    public String[] getWinners(){
        int maxPosition = findMax(getPositions());
        return (String[])CARS.stream()
                .map(car -> car.getPosition() == maxPosition)
                .toArray();
    }

    public ArrayList<Integer> getPositions(){
        ArrayList<Integer> positons = new ArrayList<>();
        for(Car car: CARS){
            positons.add(car.getPosition());
        }
        return positons;
    }

    public static int findMax(ArrayList<Integer> positions){
        return Collections.max(positions);
    }

}
