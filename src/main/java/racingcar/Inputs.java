package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Inputs {
    List<String> carNamesList = new ArrayList<>();

    public String askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return camp.nextstep.edu.missionutils.Console.readLine(); // 사용자로부터 입력받은 자동차 이름들이 쉼표로 구분되어 있는 문자열
    }
}