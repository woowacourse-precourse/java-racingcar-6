package racingcar.view;

public class OutputView {

    public void printCarNamesInputMessage() {
        System.out.println(Message.CAR_NAMES_INPUT_MESSAGE.message);
    }

    public void printExecutionNumberInputMessage() {
        System.out.println(Message.EXECUTION_NUMBER_INPUT_MESSAGE);
    }

    public void printExecutionResultMessage() {
        System.out.println(Message.EXECUTION_RESULT_MESSAGE.message);
    }

    public void printNameAndResultMessage(String name, int position) {
        System.out.println(name + " : " + "-".repeat(position));
    }

    public void printWinnersMessage(String winner) {
        System.out.println(Message.WINNER_MESSAGE.message + winner);
    }

    public void printSpaceLine() {
        System.out.println();
    }

    private enum Message {

        CAR_NAMES_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        EXECUTION_NUMBER_INPUT_MESSAGE("시도할 회수는 몇회인가요?"),
        EXECUTION_RESULT_MESSAGE("실행 결과"),
        WINNER_MESSAGE("최종 우승자 : ");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
