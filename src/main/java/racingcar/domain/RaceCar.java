package racingcar.domain;

public class RaceCar {
    private static final Character MOVE_FORWARD_CHAR = '-';
    private static final int START_CONDITION_NUM = 4;
    private static final int END_CONDITION_NUM = 9;
    private static final int INCREASE_ONE_COUNT = 1;
    private String name;
    private Integer cntMovement;
    private StringBuilder moveStateStr;

    public RaceCar() {
        this("");
    }

    public RaceCar(String nameOfRaceCar) {
        name = nameOfRaceCar;
        cntMovement = 0;
        moveStateStr = new StringBuilder();
    }

    public void movementControl(Integer numOfRan) {
        if (isMovement(numOfRan)) {
            moveForward();
        }
    }

    /**
     * 자동차의 움직여도 되는 조건 (4이상, 9이하)
     *
     * @param numOfRan "4이상, 9이하"의 값
     * @return
     */
    public boolean isMovement(Integer numOfRan) {
        return numOfRan >= START_CONDITION_NUM
                && numOfRan <= END_CONDITION_NUM;
    }

    public void moveForward() {
        increaseCntMovement();
        appendMoveState();
    }

    private void increaseCntMovement() {
        cntMovement = cntMovement + INCREASE_ONE_COUNT;
    }

    private void appendMoveState() {
        moveStateStr.append(MOVE_FORWARD_CHAR);
    }

    /**
     * 현재 자동차의 "이름"을 반환한다.
     *
     * @return
     */
    @Override
    public String toString() {
        return name;
    }

    public String toStringMoveState() {
        return moveStateStr.toString();
    }

    public Integer getCntMovement() {
        return cntMovement;
    }
}
