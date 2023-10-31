package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Inputs {
    List<String> carNamesList = new ArrayList<>();

    public String askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return camp.nextstep.edu.missionutils.Console.readLine(); // 사용자로부터 입력받은 자동차 이름들이 쉼표로 구분되어 있는 문자열
    }

    public void splitCarNames(String carNames) {
        // 문자열을 쉼표(,)로 나누어 자동차 이름 배열에 저장
        String[] carNamesArray = carNames.split(",");

        // 쉼표로 이름들이 구분되어 있는 경우: 각 요소를 자동차 이름 리스트에 추가
        if (carNamesArray.length > 0) {
            for (String carName : carNamesArray) {
                this.carNamesList.add(carName.trim()); // 공백 제거
            }
        } else { // 쉼표가 없는 경우: 문자열을 자동차 이름 리스트에 추가
            this.carNamesList.add(carNames.trim());
        }
    }
}