package racingcar.model;

public class Car {
    String name;
    String stat;

    public Car (String name, String stat){
        this.name = name;
        this.stat = stat;
    }

    public String getName() {
        return name;
    }

    public String getStat() {
        return stat;
    }

}
