package racingcar.domain;

import java.util.List;

public class ConsoleOutput implements Output {
    private static final String CAR_NAMES_INPUT_REQUEST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String MOVE_COUNT_INPUT_REQUEST = "시도할 회수는 몇회인가요?";
    private static final String RESULT_STARTED_MESSAGE = "\n실행 결과";
    private static final String WINNER_IS = "최종 우승자 : ";

    private StringBuilder stringBuilder;

    public ConsoleOutput() {
        this.stringBuilder = new StringBuilder();
    }

    @Override
    public void printCarNamesInputRequest() {
        System.out.println(CAR_NAMES_INPUT_REQUEST);
    }

    @Override
    public void printMoveCountInputRequest() {
        System.out.println(MOVE_COUNT_INPUT_REQUEST);
    }

    @Override
    public void addCarState(String name, int path) {
        stringBuilder.append("%s : ".formatted(name));
        stringBuilder.append("-".repeat(path));
        stringBuilder.append("\n");
    }

    @Override
    public void printCarsState() {
        System.out.println(stringBuilder);
        stringBuilder.setLength(0); //버퍼 비우기
    }

    @Override
    public void printResultStartedMessage() {
        System.out.println(RESULT_STARTED_MESSAGE);
    }

    @Override
    public void printWinner(List<String> winnerNameList) {
        System.out.println(WINNER_IS + String.join(", ", winnerNameList));
    }
}
