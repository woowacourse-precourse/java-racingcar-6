package racingcar.car;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import racingcar.exception.ExceptionMessage;
import racingcar.utils.Utils;

public class Car {
    List<String> names;

    public List<String> getNames(){
        return names;
    }
    public void createName(String carName){
        this.names = splitToName(carName);
    }

    private void validateName(List<String> names){
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(ExceptionMessage.NAME_OF_RANGE);
            }
        }
    }

    private List<String> splitToName(String carName){
        List<String> names = List.of(carName.split(","));
        validateName(names);
        return names;
    }

    public boolean moveToGo(){
        int result = Utils.randomNumberGenerator();
        return result >= 4;
    }
}
