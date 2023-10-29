package racingcar.view;

public class OutputValue {

    private static final String RACING_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private static final String RACING_RANGE_MESSAGE = "시도할 회수는 몇회인가요?";

    public static void getNamesMessage(){ System.out.println(RACING_CARS_NAME_MESSAGE); }

    public static void getRangeMessage(){ System.out.println(RACING_RANGE_MESSAGE); }

}
