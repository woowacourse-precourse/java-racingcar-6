package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String NUMBER_OF_ATTEMPTS_MESSAGE = "시도할 회수는 몇회인가요?";

    public static void main(String[] args) {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String inputCarNames = Console.readLine();

        List<String> carNames = getCarNames(inputCarNames);

        System.out.println(NUMBER_OF_ATTEMPTS_MESSAGE);
        int numberOfAttempts = Integer.parseInt(Console.readLine());
    }

    public static List<String> getCarNames(String inputCarNames) {
        String[] split = inputCarNames.split(",");
        List<String> carNames = new ArrayList<>(Arrays.asList(split));
        return carNames;
    }
}