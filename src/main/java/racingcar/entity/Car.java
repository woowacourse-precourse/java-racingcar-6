package racingcar.entity;

public class Car {

    private Long id;
    private String name;
    private int distance;

    public Car(Long id, String name, int distance) {
        this.id = id;
        this.name = name;
        this.distance = distance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
