package racingcar;
import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    static List<String> inputCarNameList = new ArrayList<>();
    static String inputTryNum;

    public static void main(String[] args) {
        inputCarInformation();
        inputTryCount();
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

    //시도 회수 입력 받기
    static void inputTryCount() {
        System.out.printf("시도할 회수는 몇회인가요?%n");
        inputTryNum = Console.readLine();
        for (int i = 0; i < inputTryNum.length(); i++) {
            char checkInputTryNum = inputTryNum.charAt(i);
        // 예외처리 1 : 입력 값 0으로 시작 불가 (+ 시도값 0 입력 불가)
            if (inputTryNum.charAt(0) == '0') {
                throw new IllegalArgumentException("입력 값이 0으로 시작할 수 없습니다.");
            }
        // 예외처리 2 : 숫자 형식만 입력 가능
            if (checkInputTryNum < '0' || checkInputTryNum > '9') {
                throw new IllegalArgumentException("숫자형식만 입력 가능합니다.");
            }
        }
    }
}



