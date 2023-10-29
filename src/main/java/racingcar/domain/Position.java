package racingcar.domain;

class Position {
    private int position = 0;


    public void moveForward() {
        position++;
    }

    public int getPosition() {
        return this.position;
    }

}
