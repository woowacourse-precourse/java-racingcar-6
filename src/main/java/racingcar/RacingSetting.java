package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingSetting {

    void getName() {
        String inputCarName;
        String[] carNameParsing;

        inputCarName = readLine();
        System.out.println(inputCarName);
        carNameParsing = inputCarName.split(",");
    }
}
