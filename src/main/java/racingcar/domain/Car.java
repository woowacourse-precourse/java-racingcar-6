package racingcar.domain;

public class Car {

    private final String name;
    private final StringBuilder trace = new StringBuilder();
    private int score;

    public Car(String name) {
        this.name = name;
        this.score = 0;
    }

    public void move() {
        score++;
        trace.append("-");
        System.out.println(name + " : " + trace);
    }

    public void stop() {
        System.out.println(name + " : " + trace);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
