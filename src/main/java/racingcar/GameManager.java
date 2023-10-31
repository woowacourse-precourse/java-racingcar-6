package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameManager extends Player {
    public static void newGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        List<RacingCar> player = new ArrayList<>();
        Player.getPlayer(input, player);
        CheckInput.checkLength(player);
        CheckInput.checkIsMultiple(player);

        System.out.println("시도할 회수는 몇회인가요?");
        input = Console.readLine();
        int numberTrials = CheckInput.checkIsNumber(input);
        CheckInput.checkIsNaturalNumber(numberTrials);

        Game.playGame(player, numberTrials);

        Console.close();
    }
}
