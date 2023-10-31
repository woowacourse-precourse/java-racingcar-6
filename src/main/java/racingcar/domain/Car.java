package racingcar.domain;

public class Car {
    private String name;
    private int movement;

    public Car(String name) {
        this.name = name;
    }

    void race(int randomNum) {
        if (randomNum >= 4) {
            movement++;
        }
    }

    @Override
    public String toString() {
        return name + " : " + showMovement();
    }

    public String showMovement() {
        StringBuilder score = new StringBuilder();
        for (int i = 0; i < movement; i++) {
            score.append("-");
        }
        return score.toString();
    }

    public String getName() {
        return name;
    }

    public int getMovement() {
        return movement;
    }
}
