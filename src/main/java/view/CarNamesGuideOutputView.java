package view;

public class CarNamesGuideOutputView {
    private enum Message {
        OUTPUT_GAME_START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        private final String message;

        private Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public void printGameStart() {
        System.out.println(Message.OUTPUT_GAME_START.message);
    }
}