package racingcar.view;

public class OutputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TIMES_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "\n" + "실행 결과" + "\n";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final int STRING_BUILDER_RESET_LENGTH = 0;
    private static final StringBuilder stringBuilder = new StringBuilder();

    public void carNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void timesInputMessage() {
        System.out.println(TIMES_INPUT_MESSAGE);
    }

    public void resultMessage() {
        stringBuilder.append(RESULT_MESSAGE);
    }

    public void CarNameOutput(String carName) {
        stringBuilder.append(carName).append(" : ");
    }

    public void resultCountOutput(int forwardCount) {
        for(int i=0; i<forwardCount; i++) {
            stringBuilder.append("-");
        }
        stringBuilder.append("\n");
    }

    public void printOutput() {
        System.out.println(stringBuilder);
        clearStringBuilder();
    }

    public void winnerMessage() {
        stringBuilder.append(WINNER_MESSAGE);
    }

    public void Winner(String carName) {
        stringBuilder.append(carName);
    }

    public void Winners(String carName) {
        stringBuilder.append(", ").append(carName);
    }

    private void clearStringBuilder() {
        stringBuilder.setLength(STRING_BUILDER_RESET_LENGTH);
    }
}
