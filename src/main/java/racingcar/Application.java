package racingcar;

import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String inputCarName = readLine();
        List<String> carNameList = utils.convertToList(inputCarName);
        utils.checkCarNameUnderFiveLength(carNameList);
    }
}
