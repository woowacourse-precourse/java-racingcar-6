package racingcar.model;

import racingcar.constant.CarInformConstant;
import racingcar.constant.SeparatorConstant;

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
        dash += CarInformConstant.DASH_STRING.getValue();
    }

    public String makeRacingResult() {
        return carName + SeparatorConstant.NAME_DASH_SEPARATOR.getValue() + dash;
    }

    public int getDashLen() {
        return dash.length();
    }

    public String getCarName() {
        return carName;
    }

}
