package racingcar.view;

public class OutputView {
    private final static String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String TRY_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static String RESULT_MESSAGE = "실행 결과";
    private final static String WINNER_MESSAGE = "최종 우승자";
    private final static String COLON = " : ";
    private final static String MOVE_DISTANCE = "-";
    private final static String COMMA = ",";

    public void write(String message) {
        System.out.print(message);
    }

    public void askName() {
        System.out.println(NAME_MESSAGE);
    }

    public void askTry() {
        System.out.println(TRY_MESSAGE);
    }

    public void showResultNotice() {
        System.out.println(RESULT_MESSAGE);
    }

    public void showName(String name) {
        System.out.print(name);
    }

    public void showColon() {
        System.out.print(COLON);
    }

    public void showMove(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(MOVE_DISTANCE);
        }
    }

    public void showWinnerNotice() {
        System.out.print(WINNER_MESSAGE);
    }

    public void showLine() {
        System.out.println();
    }

//    public void showWinners(List<String> winnerList) {
//        for (int name = 0; name < winnerList.size(); name++) {
//            System.out.print(winnerList.get(name));
//            if (winnerList.size() > name + 1) {
//                System.out.print(COMMA);
//            }
//        }
//    }

}