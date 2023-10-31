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
}