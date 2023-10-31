package racingcar.utils;

public class Output {
    private static final String ASK_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_GAME_COUNT = "시도할 회수는 몇회인가요?";

    public static void askCarName(){
        System.out.println(ASK_CAR_NAME);
    }

    public static void askGameCount(){
        System.out.println(ASK_GAME_COUNT);
    }

}
