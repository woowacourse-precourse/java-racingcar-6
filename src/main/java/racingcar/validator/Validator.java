package racingcar.validator;

import racingcar.model.CarList;

import java.util.List;

public class Validator {

    public static boolean isFiveOrLessCharacter(List<String> names){
        return names.stream().allMatch(name -> name.length() <= 5);
    }
}
