package racingcar.model;

public class CarInform {
    private String carName;
    private String dash;

    private CarInform(String carName) {
        this.carName = carName;
        this.dash = "";
    }

    public static CarInform getInstance(String carName) {
        return new CarInform(carName);
    }

    public void plusDash() {
        dash += "-";
    }
}
