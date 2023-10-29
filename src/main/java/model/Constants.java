package model;

public class Constants {

    private Constants() {} //생성자를 private으로 생성하여 불필요한 객체 생성 제한
    public static final String START_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String NUMBER_ATTEMPTS_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String FORWARD = "- ";
    public static final String FINAL_OUTPUT_MESSAGE = "최종 우승자 : ";
    public static final int CARNAME_MAXLENGTH = 5;
}
