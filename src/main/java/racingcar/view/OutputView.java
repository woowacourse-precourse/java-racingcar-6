package racingcar.view;

import racingcar.model.Racer;
import java.util.List;

public class OutputView {
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_MOVE_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    public static void printInputRacersNameMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public static void printInputMoveNumberMessage() {
        System.out.println(INPUT_MOVE_NUMBER_MESSAGE);
    }

    public static void printMoveResult(List<Racer> racers) {
        System.out.println("\n실행 결과");
        for (Racer racer : racers) {
            System.out.println(racer.getName() + " : " + racer.getMoveState());
        }
    }

    public static void printWinner(String winners) {
        System.out.println("\n최종 우승자 : " + winners);
    }
}