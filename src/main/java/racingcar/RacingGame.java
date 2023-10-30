package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class RacingGame {

    private ArrayList<Car> cars = new ArrayList<Car>();

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
            moveCar(car, randomNumber);
        }
    }

    void moveCar(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.moveForward();
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
            if (currentLocation > maxLocation) {
                maxLocation = currentLocation;
            }
            if (carsClassifiedByLocation.containsKey(currentLocation)) {
                carsClassifiedByLocation.get(currentLocation).add(car.getName());
                continue;
            }
            ArrayList<String> carsName = new ArrayList<>();
            carsName.add(car.getName());
            carsClassifiedByLocation.put(currentLocation, carsName);
        }
        return carsClassifiedByLocation.get(maxLocation);
     }
}
