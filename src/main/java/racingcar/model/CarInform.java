package racingcar.model;

public class CarInform {
    private String carName;
    private String dash;

    private CarInform(String carName) {
        this.carName = carName;
        this.dash = "";
    }

    public static CarInform newInstance(String carName) {
        return new CarInform(carName);
    }

    public void plusDash() {
        dash += "-";
    }

    public String makeRacingResult() {
        return carName + " : " + dash;
    }

    public int getDashLen() {
        return dash.length();
    }

    public String getCarName() {
        return carName;
    }

}
