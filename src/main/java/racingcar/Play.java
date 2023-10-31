package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Play {
    private final GameUtil gameUtil = new GameUtil();
    private final GameMessage gameMessage = new GameMessage();
    public final CarUtil carUtil = new CarUtil();

    public void play() {
        gameUtil.show(gameMessage.inputNameMessage);
        List<Car> cars = carUtil.parseCarName(Console.readLine());

        gameUtil.show(gameMessage.inputTimeMessage);
        int goal = Integer.parseInt(Console.readLine());

        Game game = new Game(cars, goal);
        gameUtil.show(gameMessage.executeMessage);
        for(int i = 0; i < goal; i++) {
            gameUtil.gameProceed(game);
            gameUtil.ProgressShow(game);
            gameUtil.show("");
        }

        System.out.println(gameMessage.finalWinnerMessage + " : " + gameUtil.getWinner(game));
    }
}

