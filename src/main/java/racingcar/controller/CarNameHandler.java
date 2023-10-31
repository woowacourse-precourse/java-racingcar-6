package racingcar.controller;

import java.util.ArrayList;
import java.util.Iterator;

public class CarNameHandler implements UserInputHandler<Iterator<String>> {
    static private final String DELIMITER = ",";
    static private final int MAX_CAR_NAME_LENGTH = 5;

    ArrayList<String> carNameList;


    public CarNameHandler() {
    }

    @Override
    public void handle(String rawCarNames) {
        String[] rawCarNameArray = rawCarNames.split(DELIMITER);
        carNameList = new ArrayList<>(rawCarNameArray.length);

        for (String rawCarName : rawCarNameArray) {
            String trimmedCarName = getTrimmedCarName(rawCarName);

            isCarNameEmpty(trimmedCarName);
            isValidLength(trimmedCarName);
            isDuplicated(trimmedCarName);

            carNameList.add(trimmedCarName);
        }
    }

    private String getTrimmedCarName(String carName) {
        return carName.trim();
    }

    private void isCarNameEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void isValidLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void isDuplicated(String carName) {
        if (carNameList.contains(carName)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Iterator<String> getHandledResult() {
        return carNameList.iterator();
    }
}
