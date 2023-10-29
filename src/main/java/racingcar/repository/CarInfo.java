package racingcar.repository;

public class CarInfo {
    private String name;
    private int distance;

    public CarInfo(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "CarInfo{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}
