package racingcar;


public class RacingCar {

    private Name name;
    private Position position;

    public RacingCar(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    /**
     * @param actionNumber 를 기준으로 자동차를 움직일지 말지 판단한다. 4이상인 경우 움직임
     */
    public void move(int actionNumber) {
        if (actionNumber < 4) {
            return;
        }

        position = position.move();
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

}
