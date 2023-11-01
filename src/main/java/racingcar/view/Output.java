package racingcar.view;

public class Output {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String DASH = "-";
    private static final char COLON = ':';
    private static final String WINNER_MESSAGE = "최종 우승자";

    public static void printInput(){
        System.out.println(START_MESSAGE);
    }
    public static void printRound(){
        System.out.println(ROUND_MESSAGE);
    }
    public static void printResult(){
        System.out.println("\n"+RESULT_MESSAGE);
    }
    public static void printScore(String name, int score){
        System.out.printf("%s %c %s\n", name, COLON, DASH.repeat(score));
    }
    public static void printWinner(String name){
        System.out.printf("%s %c %s\n",WINNER_MESSAGE, COLON, name);
    }
}
