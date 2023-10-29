package racingcar.model;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void goForward() {
        this.position++;
    }

    public String positionDrawDash() {
        StringBuilder positionDash = new StringBuilder();
        for (int positionCnt = 0; positionCnt < this.position; positionCnt++) {
            positionDash.append("-");
        }
        return positionDash.toString();
    }
}
