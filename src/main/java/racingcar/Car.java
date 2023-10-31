package racingcar;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void goForward() {
        position++;
    }

    public boolean isEqualPosition(int position) {
        return this.position == position;
    }

    public String getMoveSign(String sign) {
        StringBuilder moveSign = new StringBuilder();

        for (int i = 0; i < position; i++) {
            moveSign.append(sign);
        }

        return moveSign.toString();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
