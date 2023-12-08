package racingcar.model;

import racingcar.validation.RoundValidator;
import racingcar.validation.Validator;
import racingcar.validation.ValidatorFactory;

import static racingcar.type.PlayType.MAX_NUM;
import static racingcar.type.PlayType.MIN_NUM;

public class Round {
    private Long round;
//    private Integer round;

    private Round(String round){
        validate(round);
        this.round = Long.valueOf(round);
    }

    public static Round of(String round){
        return new Round(round);
    }

    // TODO: 진행 중인지 확인 하는 것 뿐 아니라 감소도 함
//    public Boolean isContinue(){
//        if (round > 0){
//            round --;
//            return true;
//        }
//        return false;
//    }
    public Boolean hasRound(){
//        turn();
        return round >= 0;
    }

    public void turn() {
        round--;
    }

    private void validate(String value){
        ValidatorFactory validatorFactory = ValidatorFactory.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator(this.getClass());
        validator.validate(value);
//        Validator validator = new RoundValidator();
//        validator.validate(value);
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
