package racingcar.exception;

public class CarNameException {

    public static void carNameLengthException(String name){

        if (name.length() > 5 || name.length() < 1){
            throw new IllegalArgumentException("이름은 1이상 5이하의 길이만 가능합니다.");
        }

    }

    public static void carNameSameException(){

    }

    public static void lotsOfCommaException(){

    }

    public static void blankException(){

    }
}
