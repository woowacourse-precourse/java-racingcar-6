package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class RacingCarStatus implements Comparable<RacingCarStatus> {

    private final String carName;
    private final Map<String, String> carStatus = new HashMap<>();
    private int position = 0;

    public RacingCarStatus(String carName) {
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

    @Override
    public int compareTo(RacingCarStatus otherCar) {
        return position - otherCar.getPosition();
    }
}
