package racingcar;

public class Car {
    private final String name;
    private int number;

    public Car(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void incrementNumber() {
        number++;
    }

    @Override
    public String toString() {
        return name + " : " + printNumber(number);
    }

    private String printNumber(int number) {
        StringBuilder result = new StringBuilder();
        while (number-- > 0) {
            result.append("-");
        }
        return result.toString();
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
