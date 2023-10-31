package racingcar.viewer;

public class Error_Check {
    private static final String INPUT_ERROR = "유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.";
    private static final String ROUND_ERROR = "현재 라운드는 설정한 라운드 수를 넘어 갈 수 없습니다. 프로그램을 종료합니다.";
    private static final int NAME_MAX = 5;
    private static final int NAME_MIN = 1;
    private static final int NUMBER_MAX = 2_147_483_647;
    private static final int NUMBER_MIN = 1;
    private static final int MIN_ROUND_REMAINING = 0;		//남은 라운드 최소 수.

    public static void Name(String input){
        if(input.length()<=NAME_MAX&&input.length()>=NAME_MIN)  return;
        throw new IllegalArgumentException(INPUT_ERROR);
    }

    public static int Number(String input){
        int number = Is_Number(input);
        if(number>=NUMBER_MIN&&number<=NUMBER_MAX){
            return number;
        }
        throw new IllegalArgumentException(INPUT_ERROR);
    }

    private static int Is_Number(String input){
        try{
            return Integer.parseInt(input);
        }
        catch(NumberFormatException ex) {
            throw new IllegalArgumentException(INPUT_ERROR);
        }
    }

    static public void Round(int round_number, int round_index) {
        if(round_number-round_index<MIN_ROUND_REMAINING) {
            throw new IllegalArgumentException(ROUND_ERROR);
        }
    }
}
