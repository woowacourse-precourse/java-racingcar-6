package racingcar.car;

import racingcar.random.Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCars {

    private List<Car> racingCars;

    public RacingCars(String[] cars){
        racingCars = new ArrayList<>();

        for(String name : cars){
            racingCars.add(new RacingCar(name));
        }
    }

    private int findLongestDistanceDriverOfLength(){
        int maxSize = Integer.MIN_VALUE;

        for(int i = 0; i<racingCars.size(); i++){
            if(maxSize <racingCars.get(i).distanceDriver.length())
                maxSize = racingCars.get(i).distanceDriver.length();
        }

        return maxSize;
    }

    public String findLongestDistanceDriverOfNames(){
        int maxSize = findLongestDistanceDriverOfLength();
        List<String> longestDistanceDriverOfNames = new ArrayList<>();

        for(int i = 0; i<racingCars.size(); i++){
            if(maxSize == racingCars.get(i).distanceDriver.length())
                longestDistanceDriverOfNames.add(racingCars.get(i).getName());
        }

        return String.join(", ",longestDistanceDriverOfNames);
    }

    public void moveCars(){
        for(Car car: racingCars){
            car.moveCar(Random.generate());
        }
    }

    @Override
    public String toString() {
        String executionResult = "";

        for(Car car : racingCars){
            executionResult+= racingCars.toString()+"\n";
        }

        return executionResult;
    }
}
