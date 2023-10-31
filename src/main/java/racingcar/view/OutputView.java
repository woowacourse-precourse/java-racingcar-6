package racingcar.view;

public class OutputView {
    /* 전진 횟수만큼의 하이픈(-)을 자동차 이름과 함께 반환*/
    public static String getHyphens(String name, int number) {
        String hyphen = "-";
        String hyphens = hyphen.repeat(number);
        return name + " : " + hyphens; // ex) [apple : --]
    }

    /* 경주할 자동차 이름 입력 메시지 */
    public static String pleaseInputCarsName() {
        return "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    }

    /* 시도할 횟수 입력 메시지 */
    public static String pleaseInputTriesCount() {
        return "시도할 회수는 몇회인가요?";
    }

    /* 실행 결과 시작 메시지 */
    public static String triesStartMessage() {
        return "실행 결과";
    }

    /* 최종 우승자 메시지 */
    public static String finalWinnerMessage() {
        return "최종 우승자 : ";
    }
}