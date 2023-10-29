package racingcar.domain.exception;

public class Checker {
    public static void lenCheck(String[] lineUpArr){
        for (String name : lineUpArr) {
            if(name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public static void valueCheck(String val){

    }
}
