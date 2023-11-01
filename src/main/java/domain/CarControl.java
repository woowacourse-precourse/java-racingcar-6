package domain;

import java.util.HashMap;
import java.util.List;

public class CarControl {
    private HashMap<String, Integer> carLocationMap;
    private CarMovementDecision carMovementDecision = new CarMovementDecision();
    private CarGenerator carGenerator = new CarGenerator();

    public CarControl() {
        carLocationMap = new HashMap<>();
    }

    public HashMap<String, Integer> createCarLocationMap(List<String> carNames) {
        carLocationMap = carGenerator.createLocationMap(carNames);
        return carLocationMap;
    }

    public void updateCarLocations() {
        for (String car : carLocationMap.keySet()) {
            boolean result = carMovementDecision.isCarMoving();
            if (result) {
                int currentLocation = carLocationMap.get(car);
                carLocationMap.put(car, currentLocation + 1);
            }
        }
    }

    public HashMap<String, Integer> getCarLocations() {
        return carLocationMap;
    }
}
