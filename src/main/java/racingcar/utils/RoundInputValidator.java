package racingcar.utils;

public class RoundInputValidator {
    public static void validate(String str){
        isEmpty(str);
        isNumber(str);
        isOverZero(str);
    }
    public static void isNumber(String str){
        if (!RuleConstant.NUMBER_PATTERN.matcher(str).matches()) {
            throw new IllegalArgumentException(RuleConstant.NOT_NUMBER);
        }
    }
    public static void isOverZero(String str){
        if(Integer.parseInt(str)<=0){
            throw new IllegalArgumentException(RuleConstant.MUST_OVER_ZERO);
        }
    }
    public static void isEmpty(String str){
        if(str.trim().isEmpty()){
            throw new IllegalArgumentException(RuleConstant.INPUT_EMPTY);
        }
    }
}
