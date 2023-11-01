package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.GameSystem;
import racingcar.repository.CarRepository;
import racingcar.service.GameService;
import racingcar.utils.Checker;
import racingcar.utils.Parser;
import racingcar.view.RequestMessage;
import racingcar.view.ResultMessage;

import java.util.List;

public class Controller {

    private final CarRepository carRepository = new CarRepository();
    private final Checker checker = new Checker();
    private final GameService gameService = new GameService();
    private final Parser parser = new Parser();

    public void run(){
        saveCarName(getCarNameInput());
        playGame(startGame());
    }

    private GameSystem startGame(){
        GameSystem gameSystem = new GameSystem(getCarList(),getAttemptNumFinal());
        gameService.saveGame(gameSystem);
        return gameSystem;
    }

    private void playGame(GameSystem gameSystem){
        ResultMessage.printTitle();
        while(!gameService.checkEnd(gameSystem)){
            gameService.playGame(gameSystem);
            ResultMessage.printRacingScore(gameSystem.getCarList());
        }
        ResultMessage.printWinnerList(gameService.decideWinner(gameSystem));
    }

    private List<Car> getCarList(){
        return carRepository.findAll();
    }
    private void saveCarName(List<String> playerInput){
        for(String elements : playerInput){
            carRepository.save(new Car(elements));
        }
    }

    private List<String> getCarNameInput(){
        RequestMessage.setCarName();
        String playerInputNameString=Console.readLine();
        List <String> playerInputName = parser.stringCarNameToArrayList(playerInputNameString);
        return validatePlayerInputName(playerInputNameString, playerInputName);
    }

    private List<String> validatePlayerInputName(String playerInputNameString, List<String> playerInputName){
        try{
            checker.inputCarName(playerInputNameString, playerInputName);
            return playerInputName;
        } catch (IllegalArgumentException e){
            ResultMessage.printExceptionCase(e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private int getAttemptNumFinal(){
        RequestMessage.setAttemptNum();
        String playerInput = Console.readLine();
        return parser.stringAttemptNumToInt(validatePlayerInputAttemptFinal(playerInput));
    }

    private String validatePlayerInputAttemptFinal(String playerInput){
        try{
            checker.inputAttemptFinal(playerInput);
            return playerInput;
        } catch (IllegalArgumentException e){
            ResultMessage.printExceptionCase(e.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
