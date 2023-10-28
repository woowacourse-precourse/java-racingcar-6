package racingcar.model;

public class Car {
    private final String name;
    private int result;

    public Car(String name, int result) {
        this.name = name;
        this.result = result;
    }

    public void updateResult(int count){
        this.result = result + count;
    }

    public String getName() {
        return name;
    }

    public int getResult() {
        return result;
    }
}
