package racingcar.validation;

public class InputException {

    public static String carNameValidation(String input){
        carNameLengthCheck(input);
        containBlank(input);
        black(input);
        return input;
    }
    public static void carNameLengthCheck(String input){
        for (String name : input.split(",")) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름 길이를 초과하였습니다");
            }
        }
    }

    public static void containBlank(String input){
        if(input.contains(" ")){
            throw new IllegalArgumentException("공백이 포함되어 있습니다");
        }
    }

    public static void black(String input){
        if(input.isEmpty()){
            throw new IllegalArgumentException("값을 입력해 주세요");
        }
    }
}
