package racingcar.operateProcess;

import camp.nextstep.edu.missionutils.Console;
import java.text.MessageFormat;
import java.util.List;

public class operate {

    public enum ConsoleMessage {
        CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        RESULT_IMPORMATION("실행 결과"),
        WINNER_IMPORMATION_NAME("최종 우승자 : ");

        private final String message;

        ConsoleMessage(final String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public void closeConsole() {
        Console.close();
    }

    public void printNewLine() {
        System.out.println();
    }

    public String[] getCarNames() {
        System.out.println(ConsoleMessage.CAR_NAME.getMessage());
        final String input = Console.readLine();
        return input.split(",");
    }

    public String getoperate() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return Console.readLine();
    }

    public void printRacingresult() {
        System.out.println(MessageFormat.format("\n{0}", ConsoleMessage.RESULT_IMPORMATION.getMessage()));
    }

    public void printScore(final String key, final int value) {
        String forwardAmount = "-".repeat(value);
        System.out.println(MessageFormat.format("{0} : {1}", key, forwardAmount));
    }

    public void printVictory(final List<String> names) {
        final String winners = String.join("-", names);
        System.out.println(ConsoleMessage.WINNER_IMPORMATION_NAME.getMessage() + winners);
    }
}
