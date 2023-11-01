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

    public static String inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        return getInput();
    }
    public static int inputGameRound(){
        System.out.println(INPUT_GAME_ROUND);
        return Integer.parseInt(getInput());
    }

    public static ArrayList<Car> inputCars(ArrayList<String> carNames) {
        validInputCarName(carNames);
        return createCarListByCarNames(carNames);
    }

    public static String getInput(){
        String input = Console.readLine();
        CommonValidator.validInputBlank(input);
        return input;
    }

    public static void validInputGameRound(String input) {
        CommonValidator.validInputBlank(input);
        GameRoundValidator.validInputInteger(input);
        GameRoundValidator.validNotUnderZero(Integer.parseInt(input));
    }

    public static void validInputCarName(ArrayList<String> carNames) {
        CarNameValidator.validCarNameBlank(carNames);
        CarNameValidator.validCarNameLength(carNames);
        CarNameValidator.validCarsDuplicate(carNames);
    }

    private static ArrayList<Car> createCarListByCarNames(ArrayList<String> carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for(String car : carNames) cars.add(new Car(car));
        return cars;
    }
}
