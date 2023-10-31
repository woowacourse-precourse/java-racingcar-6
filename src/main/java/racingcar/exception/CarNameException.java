package racingcar.exception;

import java.util.Arrays;

public class CarNameException {

    public static void carNameLengthException(String name){

        if (name.length() > 5 || name.length() < 1){
            throw new IllegalArgumentException("이름은 1이상 5이하의 길이만 가능합니다.");
        }

    }

    public static void carNameSameException(String[] name){

        Arrays.sort(name);

        String before="";
        for (int i = 0; i < name.length; i++) {
            if (before.equals(name[i])){
                throw new IllegalArgumentException("자동차는 각각 다른 이름을 가져야 합니다.");
            }
            before = name[i];
        }



    }

    public static void lotsOfCommaException(){

    }

    public static void blankException(){

    }
}
