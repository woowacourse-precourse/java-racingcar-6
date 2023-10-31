package racingcar;
import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static List<String> inputCarNameList = new ArrayList<>();

    public static void main(String[] args) {
        inputCarInformation();
    }
    // 자동차 이름 입력 받기
    static void inputCarInformation() {
        System.out.printf("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)%n");
        String inputCarName = Console.readLine();
        String[] inputCarNameArray = inputCarName.split(",");
        inputCarNameList = Arrays.asList(inputCarNameArray);
        for (String checkCarNameLength : inputCarNameList) {
        // 예외처리 1 : 5글자 이하만 자동차 이름으로 입력 가능
            if (checkCarNameLength.length() > 5) {
                throw new IllegalArgumentException("5글자 이하의 이름만 입력 가능합니다.");
            }
        }
        // 예외처리 2 : 자동차 이름이 중복되지 않아야 함
        Set<String> checkDuplication = new HashSet<String>(inputCarNameList);
        if (checkDuplication.size() != inputCarNameList.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}


