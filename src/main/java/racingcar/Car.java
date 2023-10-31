package racingcar;

class Car implements Comparable{
    private String name;
    private int distance;

    public Car() {}

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public int getDistance() {
        return distance;
    }
}