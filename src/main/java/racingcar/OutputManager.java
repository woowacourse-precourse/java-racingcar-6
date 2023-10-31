package racingcar;

public class OutputManager {

    public static final String CAR_NAMES_REQ_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String RACE_COUNT_REQ_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String GAME_RESULT_INFO_MESSAGE = "실행 결과";

    public void printCarNameRequestMessage() {
        System.out.println(CAR_NAMES_REQ_MESSAGE);
    }

    public void printRaceCountRequestMessage() {
        System.out.println(RACE_COUNT_REQ_MESSAGE);
    }

    public void printGameResult(GameResult gameResult) {
        System.out.println(GAME_RESULT_INFO_MESSAGE);
        gameResult.history().forEach(this::printGameSnapshot);
    }

    private void printGameSnapshot(Game game) {
        game.getCars().forEach(this::printCarPosition);
        System.out.println();
    }

    private void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        printPositionBar(car.getPosition());
    }

    private void printPositionBar(int position) {
        System.out.print("-".repeat(position));
        System.out.println();
    }
}
