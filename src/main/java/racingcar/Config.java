package racingcar;

public class Config {
    // NUMBER CONFIG
    public final static Integer Car_Name_LENGTH = 5;
    public final static Integer CanForwardMin = 4;

    // NOTIFY MESSAGE CONFIG
    public final static String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    public final static String Round_Input_MESSAGE = "시도할 회수는 몇회인가요?\n";
    public final static String Result_MESSAGE = "\n실행 결과\n";
    public final static String Winner_MESSAGE = "최종 우승자 : ";

    // ERROR MESSAGE CONFIG
    public final static String Format_Of_Round_Exception = "라운드 수는 정수여야합니다.";
    public final static String Num_Of_Round_Exception = "라운드 수는 0이상의 정수여야합니다.";


}
