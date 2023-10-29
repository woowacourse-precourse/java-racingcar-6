package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class CarStatus implements Comparable<CarStatus> {

    private final String carName;
    private final Map<String, String> carStatus = new HashMap<>();
    private int position = 0;

    public CarStatus(String carName) {
        this.carName = carName;
    }

    public void forWard() {
        this.position++;
    }

    public Map<String, String> getCarStatus() {
        String dash = "-".repeat(position);
        carStatus.put("carName", carName);
        carStatus.put("position", dash);

        return carStatus;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(CarStatus otherCar) {
        return position == otherCar.getPosition();
    }

    @Override
    public int compareTo(CarStatus otherCar) {
        return position - otherCar.getPosition();
    }
}
