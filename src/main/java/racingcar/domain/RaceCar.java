package racingcar.domain;

public class RaceCar {
    private String nameOfCar;
    private Integer cntMovementOfCar;
    private String moveStateStr;

    public RaceCar() {
        this("");
    }


    public RaceCar(String nameOfRaceCar) {
        nameOfCar = nameOfRaceCar;
        cntMovementOfCar = 0;
        moveStateStr = "";
    }

    /**
     * ranNumOfSingleDigit 이 4이상 9이하면 자동차는 이동을 한다.
     *
     * @param ranNumOfSingleDigit 0 ~ 9의 랜덤 한자릿 숫자
     * @return
     */
    public void movementControlCar(Integer ranNumOfSingleDigit) {
        if (isMovementCondition(ranNumOfSingleDigit)) {
            moveForward();
        }
    }

    /**
     * 자동차의 움직여도 되는 조건 (4이상, 9이하)
     *
     * @param ranNumOfSingleDigit 값이 4 이상, 9 이하 경우이다.
     * @return
     */
    private boolean isMovementCondition(Integer ranNumOfSingleDigit) {
        return ranNumOfSingleDigit >= 4 && ranNumOfSingleDigit <= 9;
    }

    /**
     * 차동차의 이동을 할때 "차의 이동량과 이동을 위한 출력문자"를 수정
     */
    public void moveForward() {
        // 이동시 전진 카운터 증가.
        cntMovementOfCar = cntMovementOfCar + 1;
        moveStateStr = moveStateStr + "-";
    }

    /**
     * 문자열 리턴 "one"
     *
     * @return
     */
    @Override
    public String toString() {
        return nameOfCar;
    }

    public String toStringMoveState() {
        return moveStateStr;
    }

    public Integer getCntMovementOfCar() {
        return cntMovementOfCar;
    }
}
