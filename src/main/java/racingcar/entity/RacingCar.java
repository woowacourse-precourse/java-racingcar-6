package racingcar.entity;

public class RacingCar {
    private String carName;
    private String progress = "";    // 진행도(얼마나 전진했는지 저장)

    public RacingCar(String carName) {
        this.carName = carName;
    }
}
