package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String askCarCountsAndNames() {
        return "";
    }

    public static String askHowManyRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        return readLine();
    }
}
