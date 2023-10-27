package racingcar.handler;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public List<String> convertNamesToNameList(String names) {
        if (names == null || names.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }

        String[] nameArray = names.split(",");
        List<String> nameList = new ArrayList<>();

        for (String name : nameArray) {
            String trimName = name.trim();

            validName(trimName, nameList);

            nameList.add(trimName);
        }

        return nameList;
    }

    private void validName(String trimName, List<String> nameList) {
        if (trimName.isEmpty()) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
        if (nameList.contains(trimName)) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
        if (trimName.length() >= 5) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다.");
        }
    }
}
