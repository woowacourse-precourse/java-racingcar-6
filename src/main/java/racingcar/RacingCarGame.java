package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarGame {
    public List<String> carName = new ArrayList<String>();
    public List<Integer> movementSoFar = new ArrayList<Integer>();

    public String inputString() {
        String inputStr = Console.readLine();
        return inputStr;
    }

    public void stringToList(String strCarName) {
        if (strCarName.contains(",")) {
            carName = Arrays.asList(strCarName.split(","));
        } else if (!strCarName.contains(",")) {
            carName = Arrays.asList(strCarName);
        }
    }

    public void carName() {
        String strCarName = inputString();
        // 자동차 이름 입력 완료
        stringToList(strCarName);
        setMovement();
//        System.out.println(carName);
//        System.out.println(movementSoFar);
    }

    public void setMovement() {
        for (int i = 0; i < carName.size(); i++) {
            movementSoFar.add(0);
        }
    }
}