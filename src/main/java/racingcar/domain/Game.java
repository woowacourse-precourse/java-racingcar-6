package racingcar.domain;

import racingcar.exception.Validator;

public class Game {
    int tryNumber;

    public boolean isPlay(){
        return tryNumber-- > 0;
    }

    public void setTryNumber(String tryNumber) {
        Validator.empty(tryNumber);
        Validator.integer(tryNumber);
        this.tryNumber = toInt(tryNumber);
    }

    private int toInt(String data){
        return Integer.parseInt(data);
    }
}
