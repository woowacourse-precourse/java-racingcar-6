package racingcar.domain;

public class car {

    public String name;
    public int position;

    public car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
