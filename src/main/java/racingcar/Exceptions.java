package racingcar;

import java.util.List;

public class Exceptions {
    static void ExceptCars(List<String> Cars){
        int Cars_size = Cars.size();
        if (Cars_size < 2)
            throw new IllegalArgumentException("자동차의 수가 2대 이상이어야 합니다.");

        if (Cars_size != Cars.stream().distinct().count())
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");

        for(String car : Cars){
            if (car.length() > 5)
                throw new IllegalArgumentException("자동차 이름의 길이가 5 이하여야 합니다.");

            if (car.isBlank() == true)
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }
    static int ExceptCount(String tmp_count) {
        int count;
        try {
            count = Integer.parseInt(tmp_count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 정수이어야 합니다.");
        }
        if (count < 1)
            throw new IllegalArgumentException("입력값은 1 이상이어야 합니다.");

        return count;
    }
        }

