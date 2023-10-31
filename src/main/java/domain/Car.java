package domain;

public class Car {
    private String name;  //자동차 이름
    private String now;  //현재 상황

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public Car(String name) {
        this.name = name;
        this.now = "";
    }
}