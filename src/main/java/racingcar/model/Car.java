package racingcar.model;

public class Car {

    private final String name;

    public Car(String name) {
        this.name = name;
        validate();
    }

    public String getName() {
        return name;
    }

    private void validate() {
        if(name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5글자 초과할 수 없다.");
    }

}
