package racingcar.validate.impls;

import java.util.List;
import racingcar.validate.Validator;

public class RaceGameStateValidator implements Validator {


    @Override
    public void validate(Object obj) {

    }

    private boolean isValidNameLength(String name){
        return name.length() < 6 && name.length() != 0;
    }

}
