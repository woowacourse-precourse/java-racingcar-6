package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;

public class Car {
    private LinkedHashMap<String, Integer> locations;

    private int randomNumber;

    public Car(LinkedHashMap<String, Integer> cars) {
        this.locations = cars;
    }


    public LinkedHashMap<String, Integer> moveForward(String carName, int carNumber) {
        locations = new LinkedHashMap<>();

        return locations;
    }


    public int createRandomNumber() {
        int carNumber = Randoms.pickNumberInRange(0, 9);
        return carNumber;
    }


    public LinkedHashMap<String, Integer> createLocationMap(List<String> carNameList) {
        locations = new LinkedHashMap<>();
        for (int i = 0; i < carNameList.size(); i++) {
            locations.putIfAbsent(carNameList.get(i), 0);
        }
        return locations;
    }


}
