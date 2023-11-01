package racingcar.domain;

public class Car {

    private Integer id;
    private String name;
    private Integer forwardCount;

    public Car(final Integer id, final String name) {
        this.id = id;
        this.name = name;
        this.forwardCount = 0;
    }

    public void updateForwardCount() {
        forwardCount += 1;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getForwardCount() {
        return forwardCount;
    }
}
