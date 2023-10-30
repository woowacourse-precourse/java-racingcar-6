package racingcar.model;

public class Message {
    public final String INPUT_WRONG_EXCEPTION = "잘못된 입력입니다.";
    public final String INPUT_FORM_EXCEPTION = "잘못된 형식입니다.";
    public final String CAR_NAME_EXCEPTION = "너무 긴 이름입니다.";
    public final String CAR_SIZE_EXCEPTION = "데이터 값이 하나입니다.";

    private Message() {}

    private static class SingletonHolder{
        private static final Message Instance = new Message();
    }

    public static Message getInstance() {
        return SingletonHolder.Instance;
    }
}
