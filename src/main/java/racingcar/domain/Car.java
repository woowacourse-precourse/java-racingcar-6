package racingcar.domain;

public class Car {
    private String name;
    private int current;

    public Car(String name, int current) {
        this.name = name;
        this.current = current;
    }

    public String getName() {
        return name;
    }

    public int getCurrent() {
        return current;
    }

    public void forward(int rNum, int limit) {
        if(isMoreThanDigit(limit, rNum)) {
            this.current++;
        }
    }
    public boolean isMoreThanDigit(int digit, int num) {
        return digit <= num;
    }

}
