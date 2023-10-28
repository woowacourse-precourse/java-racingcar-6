package racingcar;

public class inputValidator{

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
}