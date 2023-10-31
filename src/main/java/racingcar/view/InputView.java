package racingcar.view;

public class InputView {

    private static final String GET_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GET_NUMBER_OF_TRY = "시도할 회수는 몇회인가요?";

    public static void noticeForGetCarNameNotification(){
        System.out.println(GET_CAR_NAME);
    }

    public static void noticeForGetNumberOfTry(){
        System.out.println(GET_NUMBER_OF_TRY);
    }
}
