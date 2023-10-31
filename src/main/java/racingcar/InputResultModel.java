package racingcar;

import java.util.List;

public class InputResultModel {
    private final List<String> inputDataList;
    private final int numberOfTime;

    public List<String> getInputDataList() {
        return inputDataList;
    }

    public int getNumberOfTime() {
        return numberOfTime;
    }

    public InputResultModel(List<String> inputDataList, int numberOfTime) {
        this.inputDataList = inputDataList;
        this.numberOfTime = numberOfTime;
    }

}
