package racingcar.utils;

import racingcar.validate.ValidateNumber;

public class Output {
    private static final String ASK_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_GAME_COUNT = "시도할 회수는 몇회인가요?";
    private static final String ONE_COUNT = "-";


    public static void askCarName(){
        System.out.println(ASK_CAR_NAME);
    }

    public static void askGameCount(){
        System.out.println(ASK_GAME_COUNT);
    }

    public static void printCurrentLocation(String name, Long forwardCount) {
        System.out.println(name + " : " + makePointMessage(forwardCount));
    }

    private static String makePointMessage(Long forwardCount) {
        StringBuilder pointMessageBuilder = new StringBuilder();
        ValidateNumber.validateForwardCount(forwardCount);
        while (forwardCount > 0) {
            forwardCount--;
            pointMessageBuilder.append(ONE_COUNT);
        }
        return pointMessageBuilder.toString();
    }
}
