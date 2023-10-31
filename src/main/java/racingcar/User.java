package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private static final int CAR_NAME_LENGTH = 5;
    private static final int MINUMUM_RANGE_OF_NUMBER = 0;
    private static final int MAXIMUM_RANGE_OF_NUMBER = 9;
    private static final int DRIVE_FORWARD_NUMBER = 4;

    private static final String EXCEPTION_NAME_LENGTH_MESSAGE = "한 자동차 이름의 최대 길이는 5이하 입니다.";
    private static final String EXCEPTION_SEPARATOR_MESSAGE = "자동차의 이름을 쉼표(,)로 구분해서 입력해주세요.";
    private static final String EXCEPTION_DUPLICATION_MESSAGE = "자동차들 중에 같은 이름의 자동차가 있습니다.";
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIAL_MESSAGE = "시도할 회수는 몇회인가요?";

    public static int trialNumber;


    public void setCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        String input = inputCarName();
    }

    private static String inputCarName() { return Console.readLine(); }

    public void setTrialNumber() {
        System.out.println(INPUT_TRIAL_MESSAGE);
        String input = inputTrialNumber();
        this.trialNumber = Integer.parseInt(input);

    }

    private void vaildateStringLength(String input) {
        if (input.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_NAME_LENGTH_MESSAGE);
        }
    }

    private static String inputTrialNumber() { return Console.readLine(); }


}
