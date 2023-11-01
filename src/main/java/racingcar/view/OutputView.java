package racingcar.view;

/**
 * 프로그램에 필요한 출력 메시지를 담당하는 클래스
 */
public class OutputView {
    /** 전진 횟수만큼의 하이픈(-)을 자동차 이름과 함께 반환*/
    public static String getHyphens(String name, int number) {
        String hyphen = "-";
        String hyphens = hyphen.repeat(number);
        return name + " : " + hyphens; // ex) [apple : --]
    }

    public static String pleaseInputCarsName() {
        return "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    }

    public static String pleaseInputTriesCount() {
        return "시도할 회수는 몇회인가요?";
    }

    public static String triesStartMessage() {
        return "실행 결과";
    }

    public static String finalWinnerMessage() {
        return "최종 우승자 : ";
    }
}