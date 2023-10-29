package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {
        CheckValidation checkValidation = new CheckValidation();
        ArrayList<String> carNameList = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        carNameList = checkValidation.checkCarName(input);

    }
}
