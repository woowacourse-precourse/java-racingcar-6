package racingcar.domain;

public class RaceCar {
    private String nameOfCar;
    private Integer cntMovementOfCar;
    private String moveStateStr;

    public RaceCar() {
        nameOfCar = "";
        cntMovementOfCar = 0;
        moveStateStr = "";
    }


    public RaceCar(String nameOfRaceCar) {
        // 이름은 5자 이하만 가능하다.
        if (nameOfRaceCar.length() >= 1 && nameOfRaceCar.length() <= 5) {
            nameOfCar = nameOfRaceCar;
            cntMovementOfCar = 0;
        }
    }

    /**
     * ranNumOfSingleDigit 이 4이상 9이하면 자동차는 이동을 한다.
     *
     * @param ranNumOfSingleDigit 0 ~ 9의 랜덤 한자릿 숫자
     * @return
     */
    public Boolean movementControlCar(Integer ranNumOfSingleDigit) {
        // 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
        if (ranNumOfSingleDigit >= 4 && ranNumOfSingleDigit <= 9) {
            // moveForward() 호출
            moveForward();
            return true;
        }
        return false;
    }

    /**
     * 차동차의 이동 cntMovementOfCar의 증가.
     */
    public void moveForward() {
        // 이동시 전진 카운터 증가.
        cntMovementOfCar = cntMovementOfCar + 1;
        moveStateStr.contains("-");
    }

    // TODO: 10/27/23 자동차 멈춤(정지), 나중에 추가할지 말지 생각
    public void pauseTemp() {
//        - [ ] 멈춤은 아무런 출력을 하지 않는다.
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
