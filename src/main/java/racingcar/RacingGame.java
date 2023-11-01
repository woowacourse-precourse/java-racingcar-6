package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class RacingGame {

    private ArrayList<Car> cars = new ArrayList<Car>();
    RacingGameUtils racingGameUtils = new RacingGameUtils();

    public void createCars(String[] carNames) {
        for (int carNumber = 0; carNumber < carNames.length; carNumber++)
        {
            String carName = carNames[carNumber];
            cars.add(new Car(carName));
        }
    }

    void moveCars(RandomNumberMaker randomNumberMaker) {
        for (Car car : cars) {
            int randomNumber = randomNumberMaker.makeRandomNumber();
            racingGameUtils.moveCar(car, randomNumber);
        }
    }

     LinkedHashMap<String, Integer> getCurrentStatus() {
         LinkedHashMap<String, Integer> currStatus = new LinkedHashMap<String, Integer>();
         for (Car car : cars) {
             currStatus.put(car.getName(), car.getLocation());
         }
         return currStatus;
     }

     ArrayList<String> getWinner() {
        int maxLocation = -1;
        HashMap<Integer, ArrayList<String>> carsClassifiedByLocation = new HashMap<>();
        for (Car car : cars) {
            int currentLocation = car.getLocation();
            maxLocation = racingGameUtils.renewMaxLocation(currentLocation, maxLocation);
            if (carsClassifiedByLocation.containsKey(currentLocation)) {
                carsClassifiedByLocation.get(currentLocation).add(car.getName());
                continue;
            }
            carsClassifiedByLocation.put(currentLocation, racingGameUtils.makeCarsName(car.getName()));
        }
        return carsClassifiedByLocation.get(maxLocation);
     }
}
