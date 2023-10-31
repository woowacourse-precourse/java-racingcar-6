package racingcar.model;

import java.util.List;

public class RaceGame {
    private String inputCarName;
    private List<String> carNames;
    private List<String> carMoveCounts;
    private List<String> winnerCarNames;
    private int raceNumber;

    public void setInputCarName(String inputCarName) {
        this.inputCarName = inputCarName.replaceAll(" ", "");
    }

    public String getInputCarName() {
        return inputCarName;
    }

    public void setCarNames(List<String> carNames) {
        this.carNames = carNames;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public void setCarMoveCounts(List<String> carMoveCounts) {
        this.carMoveCounts = carMoveCounts;
    }

    public List<String> getCarMoveCounts() {
        return carMoveCounts;
    }

    public void setWinnerCarNames(List<String> winerCarNames) {
        this.winnerCarNames = winerCarNames;
    }

    public List<String> getWinnerCarNames() {
        return winnerCarNames;
    }

    public void setRaceNumber(int raceNumber) {
        this.raceNumber = raceNumber;
    }

    public int getRaceNumber() {
        return raceNumber;
    }

}
