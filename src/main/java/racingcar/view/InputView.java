package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.util.CarNameValidator;
import racingcar.util.CommonValidator;
import racingcar.util.GameRoundValidator;

import java.util.*;

public class InputView {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_GAME_ROUND = "시도할 회수는 몇회인가요?";

    public static ArrayList<String> inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        String input = getInput();
        return getCarNames(input);
    }
    public static int inputGameRound(){
        System.out.println(INPUT_GAME_ROUND);
        String input = getInput();
        return getGameRound(input);
    }

    public static String getInput(){
        String input = Console.readLine();
        CommonValidator.validInputBlank(input);
        return input;
    }

    public static ArrayList<String> getCarNames (String input) {
        ArrayList<String> carNames = new ArrayList<>(Arrays.asList(input.split(",")));
        CarNameValidator.validInputCarName(carNames);
        return carNames;
    }

    private static int getGameRound (String input) {
        GameRoundValidator.validInputGameRound(input);
        return Integer.parseInt(input);
    }

}
