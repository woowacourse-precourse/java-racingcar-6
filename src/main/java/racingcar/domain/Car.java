package racingcar.domain;

public class Car {
    Name name;
    Progress progress;

    Car(String name) {
        this.name = new Name(name);
        progress = new Progress();
    }
}
