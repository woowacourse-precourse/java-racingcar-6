package racingcar.view;

public class OutputView {
    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void displayGameResult() {
        System.out.println(Message.GAMERESULT.getMessage());
    }

    public void displayGameWinner() {
        System.out.println(Message.GAMEWINNER.getMessage());
    }

    enum Message {
        GAMERESULT("실행 결과"),
        GAMEWINNER("최종 우승자 : ");

        private String message;

        Message(String message) {
            this.message = message;
        }

        private String getMessage() {
            return message;
        }
    }
}
