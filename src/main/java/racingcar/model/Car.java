package racingcar.model;

public class Car{

    private int length;
    private String name;

    public Car(int length, String name) {
        this.length = length;
        this.name = name;
    }

    public int checkProcess(int randomNumber) {
        if (randomNumber >= 4 && randomNumber <= 9) {
            length = length + 1;
            return length;
        } else return length;
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }
}
