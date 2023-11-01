package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.GameMessage;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println(GameMessage.CARNAME_INPUT);
            CarInput carInput = CarInput.of(Console.readLine());
            System.out.println(GameMessage.TRY_COUNT_INPUT);
            Integer tryCount = Integer.parseInt(Console.readLine());
            System.out.println();

            RacingGame racingGame = new RacingGame.Builder()
                    .carInput(carInput)
                    .tryCount(tryCount)
                    .build();

            System.out.println(GameMessage.GAME_RESULT);
            racingGame.play();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

    }
}
