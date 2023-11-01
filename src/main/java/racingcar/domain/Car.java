package racingcar.domain;

public class Car implements Comparable<Car> {
    private final String name;
    private String traveledDistance;

    public Car(String name) {
        this.name = name;
        this.traveledDistance = "";
    }

    public void moveForward() {
        traveledDistance += "-";
    }

    public boolean compareTraveledDistance(Car target) {
        return traveledDistance.equals(target.traveledDistance);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name)
                .append(" : ")
                .append(traveledDistance);
        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Car o) {
        // 정렬 시 traveledDistance의 길이를 기준으로 내림차순 정렬
        return o.traveledDistance.length() - traveledDistance.length();
    }
}
