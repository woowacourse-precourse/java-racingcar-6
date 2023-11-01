package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public List<String> inputCarNames() {
        System.out.println(START_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        List<String> carNames = Arrays.asList(scanner.nextLine().trim().split("[,]"));
        checkNameException(carNames);
        return carNames;
    }

    public int inputRoundNum() {
        System.out.println(ROUND_INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String round = scanner.nextLine();
        checkRoundException(round);
        return Integer.parseInt(round);
    }

    public void checkNameException(List<String> carNames) {
        for (int i=0; i<carNames.size(); i++) {
            if( carNames.get(i).length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    public void checkRoundException(String roundNum) {
        if(!roundNum.matches("^[0-9]+")) {
            throw new IllegalArgumentException("시도 횟수는 1에서 9 사이의 정수이어야 합니다.");
        }
    }

}
