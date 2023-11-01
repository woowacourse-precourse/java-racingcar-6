package view;

public class TryCountOutputView {
    private enum Message {
        OUTPUT_GAME_START("시도할 회수는 몇회인가요?");

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