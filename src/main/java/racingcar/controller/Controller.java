package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.domain.Car;
import racingcar.model.domain.Game;
import racingcar.model.repository.CarRepository;
import racingcar.model.service.GameService;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {

    private final GameService gameService = new GameService();
    private final Parser parser = new Parser();
    private final Validator validator = new Validator();
    private final CarRepository carRepository = new CarRepository();


    public void drive(){
        saveCars(parser.parseCarNames(getCarNameByUserInput()));
        play(createGame());
    }

    private Game createGame(){
        Game game = new Game(getCarList(),getNumberOfTrial());
        gameService.save(game);
        return game;
    }
    private void play(Game game){
        OutputView.printHead();
        while (!gameService.isEnd(game)){
            gameService.play(game);
            OutputView.printScore(game.getCars());
        }
        OutputView.printWinner(gameService.getWinners(game));
    }

    private int getNumberOfTrial() {
        return parser.parseNumberOfTrial(getTrialByUserInput());
    }



    private List<Car> getCarList() {
        return carRepository.findAll();
    }
    private void saveCars(List<String> carNames){
        for (String carName:carNames
             ) {
            carRepository.save(new Car(carName));
        }
    }
    private String getTrialByUserInput() {
        InputView.requestTrialNumber();
        return checkValidationNumberOfTrial(Console.readLine());
    }

    private String checkValidationNumberOfTrial(String input) {
        try {
            validator.checkInputNumber(input);
            return input;
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return getTrialByUserInput();
        }
    }

    private String getCarNameByUserInput(){
        InputView.requestCarName();
        String input = Console.readLine();
        return checkValidationCarNamesInput(input);
    }

    private String checkValidationCarNamesInput(String input) {
        try {
            validator.checkCarNamesInput(input);
            return input;
        }catch (IllegalArgumentException e){
            OutputView.printException(e.getMessage());
            return getCarNameByUserInput();
        }
    }

}
