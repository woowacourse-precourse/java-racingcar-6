package racingcar.domain;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void increase() {
        position++;
    }

    public String createLine() {
        StringBuilder dashes = new StringBuilder();
        for (int i=0; i<position; i++) {
            dashes.append("-");
        }

        return dashes.toString();
    }

    public int getPosition() {
        return position;
    }
}