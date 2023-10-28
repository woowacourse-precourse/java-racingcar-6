package racingcar.domain.inputhandler;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;

public class CarNameInputter {
    public String getCarNames() {
        printInputMessage();
        return readCarNames();
    }

    private void printInputMessage() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private String readCarNames() {
        return readLine();
    }

    public List<String> splitCarNames(String carNames) {
        List<String> carNameList = Arrays.asList(carNames.split(","));
        return carNameList;
    }

    public Boolean validateCarName(List<String> carNameList) {
        for (int i = 0; i < carNameList.size(); i++) {
            if (carNameList.get(i).length() > 5) {
                return false;
            }
        }
        return true;
    }

}
