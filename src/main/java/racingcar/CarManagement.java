package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarManagement {
    private Map<String, Car> carLinkedHashMap;

    public Map<String, Car> getCarLinkedHashMap() {
        return this.carLinkedHashMap;
    }

    public void setCarLinkedHashMap(Map<String, Car> carLinkedHashMap) {
        this.carLinkedHashMap = carLinkedHashMap;
    }

    public CarManagement() {
        this.carLinkedHashMap = new LinkedHashMap<>();
    }

    public void addCar(String carName) {
        if (isCarExist(carName)) {
            throw new IllegalArgumentException("car already exists.");
        } else {
            this.carLinkedHashMap.put(carName, new Car(carName));
        }
    }

    public Car getCar(String carName) {
        return this.carLinkedHashMap.get(carName);
    }

    public boolean isCarExist(String carName) {
        if (this.carLinkedHashMap.containsKey(carName)) {
            return true;
        }
        return false;
    }

    public void playRound(int rangeStart, int rangeEnd, int limitNumber) {
        for (Map.Entry<String, Car> entry : this.carLinkedHashMap.entrySet()) {
            Car currentCar = entry.getValue();
            if (Randoms.pickNumberInRange(rangeStart, rangeEnd) >= limitNumber) {
                currentCar.moveCar();
            }
            showCarLocation(currentCar.getCarName());
        }
        System.out.println();
    }

    public void printWinner() {
        List<String> winnerList = new ArrayList<>();
        int record = 0;
        for (Map.Entry<String, Car> entry : this.carLinkedHashMap.entrySet()) {
            int currentLocation = entry.getValue().getCarLocation();
            if (currentLocation > record) {
                record = currentLocation;
                winnerList.clear();
                winnerList.add(entry.getKey());
            } else if (currentLocation == record) {
                winnerList.add(entry.getKey());
            }
        }
        System.out.println("최종 우승자 : " + winnerList.stream().collect(Collectors.joining(", ")));
    }

    public void showCarLocation(String carName) {
        Car currentCar = this.getCar(carName);
        System.out.println(currentCar.getCarName() + " : " + "-".repeat(currentCar.getCarLocation()));
    }
}
