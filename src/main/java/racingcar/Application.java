package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {
        CheckValidation checkValidation = new CheckValidation();
        ArrayList<String> carNameList = new ArrayList<>();
        String input;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        input = Console.readLine();
        carNameList = checkValidation.checkCarName(input);

        System.out.println("시도할 회수는 몇회인가요?");
        input = Console.readLine();
        int countTrial = checkValidation.checkIfIntAndReturnIntForm(input);

        System.out.println("\n실행 결과");
        CarRacing carRacing = new CarRacing(carNameList, countTrial);
        carRacing.race();
    }
}
