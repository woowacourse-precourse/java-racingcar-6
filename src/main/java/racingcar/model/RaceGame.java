package racingcar.model;

public class RaceGame {
    private String inputCarName;

    public void setInputCarName(String inputCarName) {
        this.inputCarName = inputCarName.replaceAll(" ", "");
    }

    public String getInputCarName() {
        return inputCarName;
    }
}
