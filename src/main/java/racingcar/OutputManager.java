package racingcar;

public class OutputManager {
    // TODO: 문자열 상수로 리팩토링
    public void printCarNameRequestMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRaceCountRequestMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printGameResult(GameResult gameResult) {
        System.out.println("실행 결과");
        gameResult.history().forEach(this::printGameSnapshot);
    }

    private void printGameSnapshot(Game game) {
        game.getCars().forEach(this::printCarSnapshot);
        System.out.println();
    }

    private void printCarSnapshot(Car car) {
        System.out.print(car.getName() + " : ");
        printPositionBar(car.getPosition());
    }

    private void printPositionBar(int position) {
        System.out.print("-".repeat(position));
        System.out.println();
    }
}
