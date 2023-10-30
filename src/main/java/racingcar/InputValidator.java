package racingcar;

public class InputValidator {

    char temp;

    public boolean checkStringLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean checkNumber(String number){
        for(int i = 0; i<number.length(); i++){
            temp = number.charAt(i);
            if (!Character.isDigit(temp)){
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
}
