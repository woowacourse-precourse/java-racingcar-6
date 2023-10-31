package racingcar;

public class InputValidator {

    public static boolean isBlank(String d){
        return d.trim().isEmpty();
    }
    public static boolean isNumber(String d){
        try {
            Integer.parseInt(d);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean checkZero(String d){
        return Integer.parseInt(d)==0;
    }

    public static boolean singleInput(String d){
        if(d.split(",").length<2){
            return true;
        }else{
            return false;
        }
    }

    public static boolean checkNameLength(String[] input){
        boolean result = false;
        for(String text : input){
            if(text.length()>5){
                result = true;
                break;
            }
        }
        return result;
    }

    static void carNameValidator(String userInput){
        if (InputValidator.isBlank(userInput)) throw new IllegalArgumentException("공백을 입력하실 수 없습니다.");
        if (InputValidator.singleInput(userInput)) throw new IllegalArgumentException("2개 이상의 이름을 입력하세요.");
        String[] splitInput = userInput.split(",");
        if(InputValidator.checkNameLength(splitInput)) throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    static void tryCountValidator(String userInput){
        if (InputValidator.isBlank(userInput)) throw new IllegalArgumentException("공백을 입력하실 수 없습니다.");
        if(!InputValidator.isNumber(userInput)) throw new IllegalArgumentException("숫자를 입력하세요.");
        if(InputValidator.checkZero(userInput)) throw new IllegalArgumentException("횟수를 제대로 입력하세요.");
    }
}