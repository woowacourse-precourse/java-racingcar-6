package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import racingcar.UserInputValidator;

public class UserInputOutput {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static final String INPUT_COUNT_GAME = "시도할 회수는 몇회인가요?";

    private static final String RUN_RESULT = "실행결과\n";

    private static final String FINAL_WINNER = "최종 우승자 : ";

    public String inputCarsName() throws IllegalArgumentException {
        System.out.println(INPUT_CAR_NAME);
        String carsName = Console.readLine();
        UserInputValidator.carNameIsValid(carsName);

        return carsName;
    }

    public String inputCount() throws IllegalArgumentException {
        System.out.println(INPUT_COUNT_GAME);
        String cnt = Console.readLine();
        UserInputValidator.attemptCountIsValid(cnt);

        return cnt;
    }

    public void printResult() {
        System.out.println(RUN_RESULT);
    }

    public void printWinner(String name) {
        System.out.println(FINAL_WINNER + name);
    }

}
