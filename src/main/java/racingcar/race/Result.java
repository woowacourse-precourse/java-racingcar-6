package racingcar.race;

public class Result {
    private String carName;
    private int distance;

    public Result(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        return result.append(carName)
                .append(" : ")
                .append("-".repeat(distance))
                .toString();
    }
}
