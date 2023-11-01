package racingcar.model;

public class TryNumber {


    private String tryNumber;

    public TryNumber(String tryNumber) {

        isDigitString(tryNumber);
        isNull(tryNumber);

        this.tryNumber = tryNumber;
    }

    public String getTryNumber() {
        return tryNumber;
    }

    public void isDigitString(String tryNumber) throws IllegalArgumentException {
        for(int i=0; i<tryNumber.length(); i++) {
            isDigitChar(tryNumber.charAt(i));
        }
    }

    public void isDigitChar(char tryNum) throws IllegalArgumentException {
        if(!Character.isDigit(tryNum)){
            throw new IllegalArgumentException();
        }
    }

    public static void isNull(String tryNumber) throws IllegalArgumentException {
        if(tryNumber.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
 }
