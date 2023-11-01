package racingcar.InputException;

import java.util.List;

public class Handler {

    public static void nameException(List<String> inputList) {
        //자동차 이름 부여 예외처리
        for(String item : inputList) {
            if(item.length() > 5) throw new IllegalArgumentException();
        }
    }


    public static boolean numberException(String num) {
        //시도할 횟수 입력에 대한 예외처리 (정규표현식 사용)
        return num.matches("[-+]?\\d*\\.?\\d+");

    }
}
