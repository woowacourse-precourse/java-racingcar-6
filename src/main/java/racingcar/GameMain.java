package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class GameMain {
    private CarListView carListView;
    private TurnRunner turnRunner;
    private TurnCounter turnCounter;
    public GameMain(){
        Prompt.GET_CAR_NAMES.print();
        List<String> commaSplittedWords = IOService.getCommaSplittedWords();
        List<Car> carList = commaSplittedWords.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.carListView = new CarListView(carList);
        this.turnRunner = new TurnRunner(carList.stream()
                .map(CarRunner::new)
                .collect(Collectors.toList()));

        Prompt.GET_TURNS.print();
        this.turnCounter = new TurnCounter(IOService.getInteger());
    }
    public void run(){
        Prompt.START_GAME.print();
        for(boolean proceed = true; proceed; proceed = turnCounter.next()){
            turnRunner.run();
            carListView.printCurrentStatus();
        }
        carListView.printWinner();
    }
}
