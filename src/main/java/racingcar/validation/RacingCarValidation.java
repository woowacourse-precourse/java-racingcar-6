package racingcar.validation;

import racingcar.domain.CarList;

public class RacingCarValidation {

    public void checkNameLength(String name){
        if(name.length() > 5)
            throw new IllegalArgumentException("해당 이름은 크키가 5 초과입니다.");
    }

}
