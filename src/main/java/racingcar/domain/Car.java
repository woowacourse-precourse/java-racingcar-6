package racingcar.domain;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getMoveHyphen() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position ; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
