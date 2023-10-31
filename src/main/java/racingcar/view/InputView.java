package racingcar.view;

import racingcar.utils.StringUtils;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIAL_NUMBER = "시도할 회수는 몇회인가요?";

    public String readInputCars() {
        System.out.println(INPUT_CAR_NAMES);
        return readLine();
    }

    public int readTrialNumber() {
        System.out.println(INPUT_TRIAL_NUMBER);
        return readInt();
    }

    private int readInt() {
        String inputInt = readLine();
        return StringUtils.stringToInt(inputInt);
    }
}
