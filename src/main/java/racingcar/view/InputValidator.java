package racingcar.view;

import java.util.List;

public class InputValidator {

    public boolean nameSplitValid(List<String> names) {
        //전체가 빈 경우
        if (names.isEmpty()) {
            return false;
        }
        //split 된 이름이 빈경우
        for (String name : names) {
            if (name.isEmpty()) {
                return false;
            }
        }
        return true;
    }

}
