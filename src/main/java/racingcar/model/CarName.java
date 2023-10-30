package racingcar.model;

public class CarName {
    private static final int LENGTH = 5;
    public static final String INPUT_NAME_LENGTH_EXCEPTION = "이름은 5자 이하만 가능합니다.";
    public static final String INPUT_NAME_EMPTY_EXCEPTION = "이름은 빈 값이나 공백은 입력할 수 없습니다.";
    public static final String INPUT_NAME_COMMA_EXCEPTION = "이름은 (,) 끝날 수 없습니다.";
    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }
    private void validate(String name){
        validateNamelength(name);
        validateNameEmpty(name);
        validateNameComma(name);
    }

    private void validateNamelength(String name){
        if(name.length()>5){
            throw new IllegalArgumentException(INPUT_NAME_LENGTH_EXCEPTION);
        }
    }
    private void validateNameEmpty(String name){
        if(name==null||name.isBlank()){
            throw new IllegalArgumentException(INPUT_NAME_EMPTY_EXCEPTION);
        }
    }
    private void validateNameComma(String name){
        if(name.endsWith(",")){
            throw new IllegalArgumentException(INPUT_NAME_COMMA_EXCEPTION);
        }
    }



}
