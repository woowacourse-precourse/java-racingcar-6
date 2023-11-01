package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameMain {
    private TurnRunner turnRunner;
    private TurnCounter turnCounter;
    private CarListView carListView;
    public GameMain(){
        Prompt.GET_CAR_NAMES.print();
        String[] carNameArray = Human.getCommaSplittedWords();
        List<Car> carList = Arrays.stream(carNameArray)
                .map(Car::new)
                .collect(Collectors.toList());
        this.turnRunner = new TurnRunner(carList.stream()
                .map(CarRunner::new)
                .collect(Collectors.toList()));

        Prompt.GET_TURNS.print();
        this.turnCounter = new TurnCounter(Human.getInteger());
        this.carListView = new CarListView(carList);
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
