package racingcar;

import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = readLine();
        List<String> carNameList = utils.convertToList(inputCarName);
        utils.checkCarNameUnderFiveLength(carNameList);

        System.out.println("시도할 회수는 몇회인가요?");
        String inputStepCount = readLine();
        Integer stepCount = utils.convertToInteger(inputStepCount);
    }
}
