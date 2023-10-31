package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.PrintMessage;

public class GameCondition {
    private static final GameCondition instance = new GameCondition();

    public static GameCondition getInstance() {
        return instance;
    }

    public int getNumberOfMoves() {
        PrintMessage.printQuestionChanceMessage();
        return Integer.parseInt(Console.readLine());
    }

    public int forwardCar() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean shouldCarMove() {
        int random = Randoms.pickNumberInRange(0, 9);
        return random >= 4;
    }

    public String generateMovedResultStick(int position) {
        return "-".repeat(position);
    }
}
