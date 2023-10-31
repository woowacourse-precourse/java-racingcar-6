package racingcar.util;

import java.util.List;

public class MessageFactory {
    public static String inputMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    public static String tryCountMessage = "시도할 회수는 몇회인가요?\n";
    public static String invalidCarNameMessageTemplate = "자동차 이름은 %d자 이하여야 합니다.";
    public static String invalidTryCountMessage = "시도 횟수는 1 이상이어야 합니다.";
    public static String gameEndingMessage = "\n실행 결과\n";

    public static String getWinnerMessage(List<String> winners) {
        return "최종 우승자 : " + String.join(", ", winners);
    }

    public static String getInvalidCarNameMessage(int maxLength) {
        return String.format(invalidCarNameMessageTemplate, maxLength);
    }
}
