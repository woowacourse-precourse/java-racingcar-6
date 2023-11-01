package racingcar.controller.dto;

import java.util.List;

public class InputDTO {

    private List<String> splitUserInput;
    private String carName;
    private int racingTryCounterl;

    public InputDTO(List<String> splitUserInput, String carName, int racingTryCounterl) {
        this.splitUserInput = splitUserInput;
        this.carName = carName;
        this.racingTryCounterl = racingTryCounterl;
    }

    public List<String> getSplitUserInput() {
        return splitUserInput;
    }

    public void setSplitUserInput(List<String> splitUserInput) {
        this.splitUserInput = splitUserInput;
    }

    public String getCarName() {
        return carName;
    }




}
