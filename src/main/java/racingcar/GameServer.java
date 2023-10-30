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
}
