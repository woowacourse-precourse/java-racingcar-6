package racingcar.domain;


import java.util.ArrayList;

public class GameService {
    private Game game;

    public GameService() {
        setGame();
        runGame();
    }

    public void setGame() {
        CarNameService carNameService = new CarNameService();
        carNameService.input();

        MoveNumberService moveNumberService = new MoveNumberService();
        moveNumberService.input();

        game = new Game(carNameService.getCarList(), moveNumberService.getMoveNumber());
    }

    public void runGame() {
        RandomNumberService randomNumberService = new RandomNumberService(game.getCarNumber());
        OutputResultOfMove outputResultOfMove = new OutputResultOfMove();
        for (int i = 0; i < game.getMoveNumber(); i++) {
            ArrayList<Car> newCarList = game.updateDistance(randomNumberService.makeResult());
            outputResultOfMove.printResultOfMove(newCarList);
        }

        decideFinalWinner();
    }

    public void decideFinalWinner() {
        StringBuilder resultSb = game.decideWinner();
        OutputFinalWinner outputFinalWinner = new OutputFinalWinner();
        outputFinalWinner.print(resultSb);
    }


}
