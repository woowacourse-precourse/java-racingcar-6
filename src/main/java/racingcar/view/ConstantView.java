package racingcar.view;

public class ConstantView {
    private enum ConstantMessage {
        GAME_START_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        RACE_START_MESSAGE("실행 결과"),
        ROUND_INPUT_MESSAGE("시도할 회수는 몇회인가요?");
        private String string;
        ConstantMessage(String message) {
            this.string = message;
        }
    }
    public static void gameStartMessage() {
        System.out.println(ConstantMessage.GAME_START_MESSAGE.string);
    }
    public static void raceStartMessage() {
        System.out.println(ConstantMessage.RACE_START_MESSAGE.string);
    }
    public static void roundInputMessage() {
        System.out.println(ConstantMessage.ROUND_INPUT_MESSAGE.string);
    }
}
