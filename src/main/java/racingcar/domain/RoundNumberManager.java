package racingcar.domain;

public class RoundNumberManager {

    public boolean notNumber(String number){
        try {
            Integer.parseInt(number);
        } catch(NumberFormatException e) {
            return true;
        }

        return false;
    }

    public static boolean negativeNumber(Integer number){
        if (number<0) {
            return true;
        }

        return false;
    }
}
