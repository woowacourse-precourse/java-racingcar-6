package racingcar.controller;

import java.util.ArrayList;
import java.util.Iterator;

public class CarNameHandler implements UserInputHandler<Iterator<String>> {
    static private final String DELIMITER = ",";
    static private final int MAX_CAR_NAME_LENGTH = 5;
    static private final int MIN_CAR_COUNT = 2;
    ArrayList<String> carNameList;


    public CarNameHandler() {
    }

    @Override
    public void handle(String rawCarNames) {
        String[] rawCarNameArray = rawCarNames.split(DELIMITER);
        int carCount = rawCarNameArray.length;
        isValidCarCount(carCount);

        carNameList = new ArrayList<>(carCount);

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

    private void isValidCarCount(int carCount){
        if (carCount < MIN_CAR_COUNT){
            throw new IllegalArgumentException(ErrorMessage.MIN_CAR_COUNT_ERROR_MESSAGE);
        }
    }

    private void isCarNameEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME_ERROR);
        }
    }

    private void isValidLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LENGTH_MESSAGE);
        }
    }

    private void isDuplicated(String carName) {
        if (carNameList.contains(carName)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATION_MESSAGE);
        }
    }

    @Override
    public Iterator<String> getHandledResult() {
        return carNameList.iterator();
    }
}
