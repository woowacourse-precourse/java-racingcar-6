package racingcar;

public class Car {
    private String name;
    private Integer position;

    public Car(String name) {
        if(name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        this.name = name;
        this.position = 0;
    }

    public String getName() { return name; }
    public Integer getPosition() { return position; }
    public void forward() {
        this.position++;
    }
}