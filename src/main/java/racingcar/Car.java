package racingcar;

public class Car {

    private String name;
    private StringBuilder position = new StringBuilder();

    public Car (String name){

        this.name = name;

    }
    public String moveForward() {

        this.position.append("-");

        return this.position.toString();
    }

    public String stop() {

        return this.position.toString();

    }
}
