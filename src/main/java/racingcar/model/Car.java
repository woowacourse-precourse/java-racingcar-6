package racingcar.model;

public class Car {
    private String name;
    // TODO: 진행한 거리 어떤 타입으로 만들지 고민하기
    // distance 

    public Car(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void forward() {
    }

    public String getDistance() {
        return "";
    }
}
