package racingcar.utill;

import java.util.Arrays;
import java.util.List;

public class Validator {

    public void validationCarName(String input){
        List<String> carNames = Arrays.stream(input.split(",")).toList();
        validationCarNamesLength(carNames);
    }

    private void validationCarNamesLength(List<String> carNames){
        carNames.stream().filter(name -> name.length() > 5 ).findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException();
                });
    }

}
