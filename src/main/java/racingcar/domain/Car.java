package racingcar.domain;

public class Car {
    private final String name;
    private int status;

    public Car(String name) {
        this.name = name;
        this.status = 0;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public void moveOrStop(int condition) {
        if (condition < 4)
            return;
        this.status++;
    }

    public void showStatus() {
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append(name).append(" : ");
        resultBuilder.append("-".repeat(this.status));
        System.out.println(resultBuilder);
    }
}
