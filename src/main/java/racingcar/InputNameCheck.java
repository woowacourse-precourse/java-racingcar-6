package racingcar;

import java.util.List;

public class InputNameCheck {
    public static void nameCheck(List<String> racerList){
        for (String racer: racerList) {
            if(racer.length() >= 6){
                throw new IllegalArgumentException("5자리 이하의 이름을 입력하세요");
            }
        }

    }
}
