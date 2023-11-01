package racingcar.domain;

import racingcar.global.utils.generator.NumberOfGamesGenerator;

public class GameNumber {

    private final ClientGameNumber clientGameNumber;

    public GameNumber(NumberOfGamesGenerator numberOfGamesGenerator) {
        clientGameNumber = new ClientGameNumber(numberOfGamesGenerator.getNumberOfGames());
    }

    public ClientGameNumber getClientGameNumber() {
        return clientGameNumber;
    }
}
