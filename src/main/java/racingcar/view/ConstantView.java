package racingcar.view;

public class ConstantView {
    private enum ConstantMessage {
        GAME_START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        RACE_START("실행 결과"),
        ROUND_INPUT("시도할 회수는 몇회인가요?");
        private String message;
        ConstantMessage(String message) {
            this.message = message;
        }
    }
    public static void gameStartMessage() {
        System.out.println(ConstantMessage.GAME_START.message);
    }
    public static void raceStartMessage() {
        System.out.println(ConstantMessage.RACE_START.message);
    }
    public static void roundInputMessage() {
        System.out.println(ConstantMessage.ROUND_INPUT.message);
    }
}
