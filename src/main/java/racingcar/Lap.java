package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Lap implements Showable, Gettable {
    private static final String lapInstruction = "시도할 회수는 몇회인가요?";

    private String lap;

    @Override
    public void showMessage() {
        System.out.println(lapInstruction);
    }

    @Override
    public String getInput() {
        return lap = readLine();
    }
}
