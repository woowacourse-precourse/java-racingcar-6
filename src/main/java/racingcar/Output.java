package racingcar;

public class Output {
    static final String guideCarNameMessage = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    static final String guideTryCountMessage = "시도할 회수는 몇회인가요?";

    public static void printGuideCarName() {
        System.out.println(guideCarNameMessage);
    }

    public static void printGuideTryCount() {
        System.out.println(guideTryCountMessage);
    }

}
