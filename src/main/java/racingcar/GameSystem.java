package racingcar;

import java.util.LinkedList;
import java.util.List;

import static racingcar.MessageType.CAR_NAMES;
import static racingcar.MessageType.EXECUTION_RESULT;
import static racingcar.MessageType.TRY_COUNT;

public class GameSystem {
    
    private final InputService inputService;
    private final OutputService outputService;
    private final CarService carService;
    private final WinnerService winnerService;
    
    private List<Car> cars;
    private List<Car> winners;
    private String resultMessage;
    
    public GameSystem() {
        inputService = new InputService();
        outputService = new OutputService();
        carService = new CarService();
        winnerService = new WinnerService();
        cars = new LinkedList<>();
        winners = new LinkedList<>();
    }
    
    public void startGame() {
        outputService.print(CAR_NAMES.getMessage());
        String carNames = inputService.getCarNames();
        cars = carService.getCars(carNames);
        
        outputService.print(TRY_COUNT.getMessage());
        int tryCount = inputService.getTryCount();
        
        runRace(tryCount);
        outputService.print(EXECUTION_RESULT.getMessage());
        outputService.print(resultMessage);
        
        winners = winnerService.getWinners(cars);
        String winnerMessage = outputService.getWinnerMessage(winners);
        outputService.print(winnerMessage);
    }
    
    private void runRace(int tryCount) {
        StringBuilder resultMessageBuilder = new StringBuilder();
        
        for (int i = 0; i < tryCount; i++) {
            carService.raceCars(cars);
            
            String resultMessagePerCycle = outputService.getResultMessage(cars);
            resultMessageBuilder.append(resultMessagePerCycle).append("\n");
        }
        
        resultMessage = resultMessageBuilder.toString();
    }
}
