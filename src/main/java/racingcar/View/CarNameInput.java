package racingcar.View;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CarNameInput {
    public List<String> playerList() {
        String allList = readLine();

        String[] nameArray = allList.split(",");
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nameArray.length; i++) {
            result.add(nameArray[i]);
            nameException(nameArray[i]);
            if (result.size() != result.stream().distinct().count()) {
                throw new IllegalArgumentException();
            }
        }

        return result;
    }

    public void nameException(String name) {
        nameIsDigit(name);
        nameOverLength(name);
        nameIsNull(name);
    }

    public void nameIsDigit(String name) {
        if (Character.isDigit(name.charAt(0))) {
            throw new IllegalArgumentException("글자를 입력하셔야 합니다");
        }
    }

    public void nameOverLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("차 이름이 5글자를 넘었습니다.");
        }
    }

    public void nameIsNull(String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException("차 이름이 null 값 입니다.");
        }
    }
}
