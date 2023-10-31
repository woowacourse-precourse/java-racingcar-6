package view;

public class Output_view {
    static final String GAME_START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_OF_GAME_MATCHES = "시도할 회수는 몇회인가요?";
    private static final String CAR_DEPRTURE = "실행 결과";
    private static final String RESULT_OF_THE_GAME = "최종 우승자 : ";
    private static final String MOVE_CHECK = "-";

    public static void GameStart(){System.out.println(GAME_START);}
    public static void NumberOfGameMatches(){
        System.out.println(NUMBER_OF_GAME_MATCHES);
    }
    public static void CarDeprture(){System.out.println(CAR_DEPRTURE);}
    public static void ResultOfTheGame(String winner){
        System.out.println(RESULT_OF_THE_GAME + winner);
    }
    public static void Error(){
        throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
    }
    public static void move_car(String carName, int moveCount){
        String moveing_string = "";
        for(int i = 0; i < moveCount; i++) {
            moveing_string = String.format("%s%s", moveing_string, MOVE_CHECK);
        }
        System.out.println(carName + " : " + moveing_string);
    }
    public static void new_line() {
        System.out.println();
    }
}

