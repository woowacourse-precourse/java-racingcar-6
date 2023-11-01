package racingcar;

import java.util.List;

public class OutputManager {

    public static final String CAR_NAMES_REQ_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String RACE_COUNT_REQ_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String GAME_RESULT_INFO_MESSAGE = "실행 결과";
    public static final String WINNERS_INFO_MESSAGE = "최종 우승자 : ";

    public void printCarNameRequestMessage() {
        System.out.println(CAR_NAMES_REQ_MESSAGE);
    }

    public void printRaceCountRequestMessage() {
        System.out.println(RACE_COUNT_REQ_MESSAGE);
    }

    public void printGameResult(GameResult gameResult) {
        System.out.println();
        System.out.println(GAME_RESULT_INFO_MESSAGE);
        gameResult.history().forEach(this::printRaceSnapshot);
        printWinners(gameResult.winners());
    }

    private void printRaceSnapshot(RaceSnapshot race) {
        race.cars().forEach(this::printCarPosition);
        System.out.println();
    }

    private void printCarPosition(CarSnapshot car) {
        System.out.print(car.name() + " : ");
        printPositionBar(car.position());
        System.out.println();
    }

    private void printPositionBar(int position) {
        System.out.print("-".repeat(position));
    }

    public void printWinners(List<CarSnapshot> winners) {
        System.out.print(WINNERS_INFO_MESSAGE);

        System.out.print(winners.get(0).name());
        winners.stream()
                .skip(1)
                .forEach(this::printNextCarName);
    }

    private void printNextCarName(CarSnapshot car) {
        System.out.print(", " + car.name());
    }
}
