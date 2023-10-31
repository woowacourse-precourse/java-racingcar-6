package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class MissionUtilsInput implements Input {

    @Override
    public String read() {
        return readLine();
    }

}