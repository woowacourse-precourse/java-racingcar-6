package racingcar.service;

import java.util.List;
import racingcar.exception.InvalidCountException;
import racingcar.exception.InvalidNameException;

public class RacingService {
    public void validateNames(List<String> racerList){
        for (String name : racerList) {
            if (name.isEmpty() || name.length() > 5) {
                throw new InvalidNameException("이름은 공백일 수 없으며, 5자를 초과할 수 없습니다.");
            }
        }
    }

    public void validateCount(String count){
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new InvalidCountException("입력한 값이 숫자가 아닙니다.");
        }
    }
}
