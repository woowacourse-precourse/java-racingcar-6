package racingcar.domain.car;

public class Car implements Comparable<Car> {
    private String name;
    private int currentLocation;

    private Car() {
    }

    private Car(String name, int currentLocation) {
        this.name = name;
        this.currentLocation = currentLocation;
    }

    public static Car createCar(String name, int currentLocation) {
        return new Car(name, currentLocation);
    }

    public void moveForward() {
        this.currentLocation += 1;
    }

    // 실행결과 별 선수상태를 반환
    @Override
    public String toString() {
        StringBuilder status = new StringBuilder("");
        for (int i = 0; i < currentLocation; i++) {
            status.append("-");
        }
        return this.name + " : " + status.toString();
    }

    public String getName() {
        return name;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(o.getCurrentLocation(), this.currentLocation); // 오름차순 정렬
    }
}
