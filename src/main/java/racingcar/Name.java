package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Name {
    public static List<String> validateNames(String userInput) {
        String[] names = userInput.split(",");
        List<String> nameList = new ArrayList<>();
        for (String name : names) {
            String cutName = name.trim();
            if (cutName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름을 입력하세요");
            }
            if (cutName.length() >= 6) {
                throw new IllegalArgumentException("5자 이하로 입력하세요.");
            }
            nameList.add(cutName);
        }
        return nameList;
    }
}