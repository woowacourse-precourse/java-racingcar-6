package racingcar;

public class InputValidator {

    public boolean isBlank(String d){
        return d.trim().isEmpty();
    }
    public boolean isNumber(String d){
        try {
            Integer.parseInt(d);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public boolean singleInput(String d){
        if(d.split(",").length<2){
            return true;
        }else{
            return false;
        }
    }
}