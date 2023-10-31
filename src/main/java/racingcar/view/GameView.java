package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    public String requestCarInputRequest() {
        System.out.println(OuputMessage.CAR_INPUT_REQUEST.getMessage());
        return Console.readLine();
    }

    public String requestAttemptsNum() {
        System.out.println(OuputMessage.ATTEMPTS_NUM_INPUT_REQUEST.getMessage());
        return Console.readLine();
    }
    public void printPreResultMessage() {
        System.out.println(OuputMessage.PRE_RESULT_MESSAGE.getMessage());
        return;
    }

    public void printResult(String result) {
        System.out.println(result);
        return;
    }

    public void printWinner(String winner) {
        System.out.println(OuputMessage.WINNER.getMessage() + winner);
        return;
    }

    enum OuputMessage {
        CAR_INPUT_REQUEST("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        ATTEMPTS_NUM_INPUT_REQUEST("시도할 회수는 몇회인가요?"),
        WINNER("최종 우승자 : "),
        PRE_RESULT_MESSAGE("실행 결과");

        private String message;

        OuputMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
