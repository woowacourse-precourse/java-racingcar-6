package racingcar.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {

    public List<String> validateInputCarName(String inputCarName) {
        Set<String> uniqueWords = new HashSet<>();
        List<String> carName = new ArrayList<>();

        for (String word : inputCarName.split(",")) {
            System.out.println("word = " + word);
            if (!uniqueWords.add(word)) {
                throw new IllegalArgumentException("중복된 단어가 있습니다.");
            } else if (word.isEmpty()) {
                throw new IllegalArgumentException("빈 문자는 입력할 수 없습니다.");
            } else if (word.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에 공백은 포함될 수 없습니다.");
            } else if (!word.matches("^[A-Za-z0-9]+$")) {
                throw new IllegalArgumentException("자동차 이름에 특수 문자는 포함될 수 없습니다.");
            } else if (!(word.length() > 5)) {
                throw new IllegalArgumentException("자동차 이름은 5글자를 이하만 가능합니다.");
            }
            carName.add(word);
        }
        return carName;
    }
}
