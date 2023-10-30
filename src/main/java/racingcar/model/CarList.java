package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.views.SystemMessage;

public class CarList {
    private List<String> carList;

    SystemMessage systemMessage = new SystemMessage();

    public List<String> getCarList() {
        return this.carList;
    }

    public List<String> setCarList() {
        return this.convertToList(systemMessage.getCarList());
    }

    private List<String> convertToList(String input) {
        return Arrays.asList(input.split(","));
    }
}
