package racingcar.validation;

public class InputException {

    public static String carNameValidation(String input){
        carNameLengthCheck(input);
        containBlank(input);
        black(input);
        return input;
    }
    public static String numberValidation(String input){
        numberCheck(input);
        underZeroNumber(input);
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

    public static void numberCheck(String input){
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException("숫자값을 입력해주세요");
        }
    }

    public static void underZeroNumber(String input){
        if(Integer.parseInt(input)<= 0){
            throw new IllegalArgumentException("0보다 큰 값을 입력해주세요");
        }
    }
}
