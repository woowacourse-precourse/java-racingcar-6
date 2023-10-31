package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.GameSystem;
import racingcar.repository.CarRepository;
import racingcar.service.GameService;
import racingcar.utils.Parser;
import racingcar.view.RequestMessage;
import racingcar.view.ResultMessage;

import java.util.List;

public class Controller {

    private final CarRepository carRepository = new CarRepository();
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
        return parser.stringCarNameToArrayList(Console.readLine());
    }

    private int getAttemptNumFinal(){
        RequestMessage.setAttemptNum();
        return parser.stringAttemptNumToInt(Console.readLine());
    }
    //TODO : validator 확인
    //TODO : 기능 테스트 작성
}
