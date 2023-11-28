package racingcar.model;

import racingcar.validation.RoundValidator;
import racingcar.validation.Validator;

import static racingcar.type.PlayType.MAX_NUM;
import static racingcar.type.PlayType.MIN_NUM;

public class Round {
    private Integer round;

    public Round(String round){
        validate(round);
        this.round = Integer.parseInt(round);
    }

    // TODO: 진행 중인지 확인 하는 것 뿐 아니라 감소도 함
    public Boolean isContinue(){
        if (round > 0){
            round --;
            return true;
        }
        return false;
    }

    private void validate(String value){
        Validator validator = new RoundValidator();
        validator.validate(value);
//        validateType(value);
//        validateRange(value);
    }

//    private void validateType(String value){
//        if (value != null && !value.matches(ONLY_NUMBER)){
//            throw new IllegalArgumentException();
//        }
//    }
//
//    private void validateRange(String value){
//        if (0 >= Integer.parseInt(value)) {
//            throw new IllegalArgumentException();
//        }
//    }
}
