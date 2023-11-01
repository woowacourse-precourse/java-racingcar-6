package racingcar;

public class Car {
    private String name;
    private Integer locate;

    public Car(String name, Integer locate) {
        this.name = name;
        this.locate = locate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLocate() {
        return locate;
    }

    public void setLocate(Integer locate) {
        this.locate = locate;
    }
}
