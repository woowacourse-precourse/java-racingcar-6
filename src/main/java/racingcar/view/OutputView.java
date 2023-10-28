package racingcar.view;

import racingcar.model.Car;

public class OutputView {
    private final static String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)";
    private final static String TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static String PLAY_MESSAGE = "실행 결과";
    private final static String RESULT_MESSAGE = "최종 우승자 : ";

    public static void inputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    public static void truCountMessage() {
        System.out.println(TRY_COUNT_MESSAGE);
    }

    public static void playMessage() {
        System.out.println("");
        System.out.println(PLAY_MESSAGE);
    }

    public static void resultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void positionShow(Car car){
        for(int i=0; i<car.getCarPosition(); i++){
            System.out.print("-");
        }
        System.out.println("");
    }

    public static void carNameShow(Car car){
        System.out.print(car.getCarName()+" : ");
    }
}