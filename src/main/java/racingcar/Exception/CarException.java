package racingcar.Exception;

import java.util.*;
import racingcar.Message.ExceptionMessage;

public class CarException {
    Set<String> nameSet;
    public boolean checkExceptionCar(String names){
        nameSet = new HashSet<>();
        String[] cars = checkNameCount(names);
        for (String car : cars) {
            car = car.trim();
            if (validateName(car)){
                checkFiveWords(car);
                checkSpaceWords(car);
                isSameName(car);
            }
        }
        return true;
    }
    public String[] checkNameCount(String names){
        if (Arrays.stream(names.split(",")).count() <= 1)
            throw new IllegalArgumentException(ExceptionMessage.ONE_CAR_ERROR);
        return names.split(",");
    }
    public boolean validateName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException(ExceptionMessage.NOTHING_ERROR);
        return true;
    }
    public void checkFiveWords(String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException(ExceptionMessage.FIVE_LENGTH_ERROR);
    }
    public void checkSpaceWords(String name) {
        if (name.contains(" "))
            throw new IllegalArgumentException(ExceptionMessage.IS_SPACE_ERROR);
    }
    public void isSameName(String name){
        if (!nameSet.add(name)) {
            throw new IllegalArgumentException(ExceptionMessage.SAME_NAME_ERROR);
        }
    }

}
