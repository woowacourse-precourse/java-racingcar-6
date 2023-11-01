package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameManager {
    public static void launch(){
        List<String> carNames = getCarNames();
        int tryCount = getTryCount();

        RacingCarGame.play(carNames, tryCount);
    }

    private static List<String> getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        List<String> carNames = List.of(carNamesInput.split(","));
        carNames.forEach((Discriminator::validateCarName));
        Discriminator.validateCarNumber(carNames.size());
        return carNames;
    }

    private static int getTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        String tryCountInput = Console.readLine();
        Discriminator.validateTrialCount((tryCountInput));
        return Integer.parseInt(tryCountInput);
    }
}
