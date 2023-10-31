package racingcar.view;

import racingcar.game.Car;

public class OutputView {
    // TODO: Message enum으로 빼기
    private final static String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String ASK_GAME_ROUNDS = "시도할 횟수는 몇회인가요?";
    private final static String GAME_RESULT = "실행 결과";
    private final static String DISPLAY_USER_SCORE_SIGN = ":";
    private final static String SCORE_SIGN = "-";
    private final static String FINAL_WINNER = "최종 우승자 :";

    public static void startGame(){
        System.out.println(START_MESSAGE);
    }

    public static void askGameRounds(){
        System.out.println(ASK_GAME_ROUNDS);
    }

    public static void startGameResult(){
        System.out.println(GAME_RESULT);
    }

    public static void broadcastUserBoardOfRound(Car car){
        // TODO: getter 없이 쓸 수 있는 방법 고민 해보기
        System.out.printf("%s %s ", car.getCarName(), DISPLAY_USER_SCORE_SIGN);
        for(int i=0; i<car.getScore(); i++){
            System.out.printf("%s", SCORE_SIGN);
        }
        System.out.println();
    }

    public static void theEndOfRound(){
        System.out.println();
    }

    public static void finalGameResult(String cars){
        System.out.printf("%s %s",FINAL_WINNER, cars);
    }
}
