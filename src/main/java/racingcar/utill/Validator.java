package racingcar.utill;

import java.util.Arrays;
import java.util.List;

public class Validator {

    public void validationCarName(String input){
        List<String> carNames = Arrays.stream(input.split(",")).toList();
        validationCarNamesLength(carNames);
        validationCarNamesListLength(carNames);
    }

    private void validationCarNamesLength(List<String> carNames){
        carNames.stream().filter(name -> name.length() > 5 )
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException();
                });
    }
    private void validationCarNamesListLength(List<String> carNames){
        if(carNames.size() < 2){
            throw  new IllegalArgumentException();
        }
    }

    public void validationCount(String input){
        validationCountIsZero(input);
        validationCountnumeric(input);
    }

    private void validationCountnumeric(String input) {
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    private void validationCountIsZero(String input) {
        if(input.equals("0")){
            throw new IllegalArgumentException();
        }
    }
}
