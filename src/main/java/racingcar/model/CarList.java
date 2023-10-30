package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.views.SystemMessage;
import racingcar.constant.Constants;

public class CarList {
    private List<String> carList;
    private Integer trial;

    SystemMessage systemMessage = new SystemMessage();

    public List<String> getCarList() {
        return this.carList;
    }

    public void setCarList() {
        this.carList = this.convertToList(systemMessage.getCarList());
    }

    public Integer getTrial() {
        return this.trial;
    }

    public void setTrial() {
        this.trial = Integer.parseInt(systemMessage.getTrialNumber());
    }

    private List<String> convertToList(String input) {
        List<String> inputList = Arrays.asList(input.split(","));
        if (!isValid(inputList)) {
            throw new IllegalArgumentException(Constants.INPUT_ERROR);
        }
        return inputList;
    }

    private boolean isValid(List<String> input) {
        for (String s : input) {
            if (s.length() > 5) {
                return false;
            }
        }
        return true;
    }
}
