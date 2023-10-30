package racingcar.model;

public class GameModel {

    private static final int MIN_GAME_NUMBERS = 1;
    private Cars carList;
    private int numberGames;

    public GameModel(Cars carList, int numberGames) {
        validateNumberGames(numberGames);
        this.carList = carList;
        this.numberGames = numberGames;
    }

    public void validateNumberGames(int numberGames) {
        if (numberGames < MIN_GAME_NUMBERS) {
            throw new IllegalArgumentException();
        }
    }

}
