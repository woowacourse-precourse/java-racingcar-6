package racingcar.Model;

import java.util.List;

public class RacingData {
    private String carName; //자동차 이름
    private List<String> racingCar; //사용자가 입력할 자동차 이름을 저장할 리스트
    private int moveNumber; //이동 횟수
    private List<Integer> moveValidationNumber; //전진과 멈춤을 판단하는 난수를 저장 할 리스트

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public List<String> getRacingCar() {
        return racingCar;
    }

    public void setRacingCar(List<String> racingCar) {
        this.racingCar = racingCar;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public void setMoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    public List<Integer> getMoveValidationNumber() {
        return moveValidationNumber;
    }

    public void setMoveValidationNumber(List<Integer> moveValidationNumber) {
        this.moveValidationNumber = moveValidationNumber;
    }
}
