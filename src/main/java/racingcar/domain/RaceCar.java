package racingcar.domain;

// TODO: 10/27/23 경주를 하는 자동차 생성하는 클래스.
public class RaceCar {
    private String nameOfCar;
    private Integer cntMovementOfCar;

    // TODO: 10/27/23 생성자 생성
    public RaceCar() {
        nameOfCar = "";
        cntMovementOfCar = 0;
    }

    public RaceCar(String nameOfRaceCar) {
        // 이름은 5자 이하만 가능하다.
        // 생성자를 통해서 입력을 받는다.

        if (nameOfRaceCar.length() >= 1 && nameOfRaceCar.length() <= 5) {
            nameOfCar = nameOfRaceCar;
            cntMovementOfCar = 0;
        }
    }

    // TODO: 10/27/23 자동차의 이동을 제어해준다.
    public Boolean movementControlCar(Integer ranNumOfSingleDigit) {
        // 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
        if (ranNumOfSingleDigit >= 4 && ranNumOfSingleDigit <= 9) {
            // moveForward() 호출
            moveForward();
            return true;
        }
        return false;
    }

    public void moveForward() {
//        이동시 전진 카운터 증가.
        cntMovementOfCar = cntMovementOfCar + 1;
    }

    // TODO: 10/27/23 자동차 멈춤(정지), 나중에 추가할지 말지 생각
    public void pauseTemp() {
//        - [ ] 멈춤은 아무런 출력을 하지 않는다.

    }

    @Override
    public String toString() {
        return nameOfCar;
    }

    public Integer getCntMovementOfCar() {
        return cntMovementOfCar;
    }
}
