package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class UserInputView {

    private static final String WELCOME_MESSAGE = "환영합니다! 지금부터 자동차 경주 게임을 시작합니다.";
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 직접 입력하십시오.";
    private static final String ALERT_MESSAGE = " (주의사항: 본 게임은 최대 3명까지 이용 가능하며 이름은 쉼표(,)로 구분하고 "
            + "5자 이하의 이름으로 입력할 것)";
    private static final String TRY_TIMES_MESSAGE = "시도할 횟수는 몇 회입니까?";

    private List<String> carNames = new ArrayList<>();
    private int tryTimes = 0;

    public List<String> getCarNames() {
        System.out.println(WELCOME_MESSAGE);
        System.out.print(INPUT_CAR_NAMES_MESSAGE);
        System.out.println(ALERT_MESSAGE);
        String userInput = Console.readLine();

        Errors.namingError(userInput);

        return splitCarNames(userInput);
    }

    private List<String> splitCarNames(String userInput) {
        String[] nameArray = userInput.split(",");
        List<String> carNames = new ArrayList<>();

        for (String name : nameArray) {
            carNames.add(name.replaceAll("\\s", "").trim());
        }
        return carNames;
    }

    public int getTryTimes() {
        System.out.println(TRY_TIMES_MESSAGE);
        String userInputNumber = Console.readLine();
        int userInputTrialNumber = Integer.parseInt(userInputNumber);

        Errors.inputWrongNumberError(userInputNumber);
        Errors.inputNegativeNumberError(userInputTrialNumber);
        Errors.inputZeroError(userInputTrialNumber);

        return userInputTrialNumber;
    }

}