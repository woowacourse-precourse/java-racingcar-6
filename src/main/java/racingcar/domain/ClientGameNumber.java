package racingcar.domain;

import racingcar.global.constant.OutputType;

public class ClientGameNumber {

    private final Integer numberOfGames;

    public ClientGameNumber(Integer numberOfGames) {
        validateNumber(numberOfGames);
        this.numberOfGames = numberOfGames;
    }

    private void validateNumber(Integer numberOfGames) {
        if (isWrongInput(numberOfGames)) {
            throw new IllegalArgumentException(OutputType.EXCEPTION.getComment());
        }
    }

    private boolean isWrongInput(Integer numberOfGames) {
        return !(allowsPositiveValue(numberOfGames));
    }

    private boolean allowsPositiveValue(Integer numberOfGames) {
        return numberOfGames > 0;
    }

    public Integer getNumberOfGames() {
        return numberOfGames;
    }
}
