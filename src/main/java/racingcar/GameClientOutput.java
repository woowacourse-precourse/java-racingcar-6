package racingcar;

import java.util.List;

public class GameClientOutput {
    private static final String INPUT_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_MOVES_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String WINNERS_MESSAGE = "최종 우승자 : ";

    public void printForAskingNames() {
        System.out.println(INPUT_NAMES_MESSAGE);
    }

    public void printForAskingMoves(){
        System.out.println(INPUT_MOVES_MESSAGE);
    }

    public void printWinners(List<String> winners) {
        System.out.print(WINNERS_MESSAGE);
        System.out.println(String.join(", ", winners));
    }
}
