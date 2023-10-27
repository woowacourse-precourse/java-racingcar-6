package racingcar.view;

public class RequestMessage {
    private static final String CAR_NAME="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_NUM="시도할 회수는 몇회인가요?";

    public static void setCarName(){
        System.out.println(CAR_NAME);
    }

    public static void setAttemptNum(){
        System.out.println(ATTEMPT_NUM);
    }

}
