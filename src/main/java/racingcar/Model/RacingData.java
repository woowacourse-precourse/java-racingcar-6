package racingcar.Model;

import java.util.List;
import java.util.Map;
import racingcar.View.InputView;

public class RacingData {
    private String carName;
    private static Map<String,Integer> racingCar;
    private String moveNumber;
    private List<Integer> moveValidationNumber;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public static Map<String,Integer> getRacingCar() {
        return racingCar;
    }

    public void setRacingCar(Map<String,Integer> racingCar) {
        this.racingCar = InputView.storeCarName();
    }

    public String getMoveNumber() {
        return moveNumber;
    }

    public void setMoveNumber(String moveNumber) {
        this.moveNumber = moveNumber;
    }

    public List<Integer> getMoveValidationNumber() {
        return moveValidationNumber;
    }

    public void setMoveValidationNumber(List<Integer> moveValidationNumber) {
        this.moveValidationNumber = moveValidationNumber;
    }
}
