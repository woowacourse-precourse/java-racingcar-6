package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.domain.Utils.*;

public class User {
    public List<String> inputCarName() {
        String totalCarName = readLine();
        String[] carNames = totalCarName.split(",");
        List<String> carNameList = new ArrayList<>();

        if (checkNameOverLengthException(carNames))
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");

        return translateArrayToList(carNames, carNameList);
    }

    public int inputNumberOfCarMovement() {
        String tempNumberOfCarMovement = readLine();
        if (checkStringToIntException(tempNumberOfCarMovement))
            throw new IllegalArgumentException("올바르지 않은 입력입니다. 숫자를 입력하세요.");
        return Integer.parseInt(tempNumberOfCarMovement);
    }
}
