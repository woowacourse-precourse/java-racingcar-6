package racingcar.car;

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

    public String find
}
