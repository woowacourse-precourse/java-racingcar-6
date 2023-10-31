package racingcar.domain;

public class GameService {
    private Game game;

    public void setGame() {
        CarNameService carNameService = new CarNameService();
        carNameService.input();

        MoveNumberService moveNumberService = new MoveNumberService();
        moveNumberService.input();

        game = new Game(carNameService.getCarList(), moveNumberService.getMoveNumber());
    }

}
