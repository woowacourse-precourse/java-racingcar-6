package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingService {

    private final InputView inputView;
    private final OutputView outputView;
    private Racing racing;

    public RacingService(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public void initRacing(){
        List<String> carNameList = inputView.InputCarNames();
        List<Car> cars = carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        Integer totalRound = inputView.InputTotalRoundNumber();
        racing = new Racing(cars,totalRound);
    }

    public void startRacing(){
        outputView.printResultMessage();
        while (!racing.isRacingOver()){
            racing.proceedRound();
            racing.allCarsDecideMoving();
            outputView.printCarDistanceNow(racing);
        }
    }

    public void announceWinner(){
        List<String> winnerNames = racing.getWinnerNames();
        outputView.printRacingWinner(winnerNames);
    }
}
