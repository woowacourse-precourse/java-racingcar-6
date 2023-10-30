package racingcar;

final class GameServer {

    private Cars cars;
    private Count count;
    private final Roulette roulette;

    GameServer(Roulette roulette) {
        this.roulette = roulette;
    }


    private void initializeCars() {
        Output.printInputNames();
        cars = new Cars(roulette, Input.receiveInput());
    }

    private void initializeCount() {
        Output.printInputCount();
        count = Count.create(Input.receiveInput());
    }

    private void doTurn() {
        cars.tryMove();
        count.countDown();
        Output.printGameResult(cars.collectCurrentStatus());
    }

    private void showWinners() {
        Output.printWinner(cars.whosWinners());
    }

    private void endGame() {
        Input.stopReceivingInput();
    }
}
