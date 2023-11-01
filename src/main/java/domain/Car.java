package domain;

public class Car implements Comparable<Car>{
    private static final String SPERATOR = " : ";
    private static final String PROGRESS = "-";
    private String name;
    private int distance;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.distance = 0;
    }

    public void forward() {
        this.distance++;
    }

    private void validateNameLength(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름이 존재하지 않습니다!");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름이 5글자를 초과합니다!");
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(name);
        result.append(SPERATOR);
        result.append(PROGRESS.repeat(Math.max(0, distance)));
        return result.toString();
    }

    @Override
    public int compareTo(Car otherCar) {
        return Integer.compare(this.distance, otherCar.distance);
    }
}
