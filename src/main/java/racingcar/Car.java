package racingcar;

public class Car {

    int score;
    String name;

    public Car(String name) {
        this.score = 0;
        this.name = name;
    }

    void gainScore() {
        this.score++;
    }

}
