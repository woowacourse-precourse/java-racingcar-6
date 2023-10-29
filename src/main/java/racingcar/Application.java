package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {

    public void informInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public String inputCarNames() {
        return Console.readLine();
    }

    public List<String> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }

    public void validateCarNameLength(List<String> carName) {
        if(carName.stream().anyMatch(name -> name.length() >= 5)) {
            throw new IllegalArgumentException("입력한 자동차 이름중에 5자가 넘는 이름이 있습니다.");
        }
    }

    public static void checkEnglishInput(String inputStr) {
        if (!inputStr.matches("^[a-zA-Z]*$")) {
            throw new IllegalArgumentException("입력한 값은 영어가 아닙니다. 영어 문자만 허용됩니다.");
        }
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
