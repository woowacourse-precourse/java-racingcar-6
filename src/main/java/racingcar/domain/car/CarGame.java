package racingcar.domain.car;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import racingcar.domain.input.Input;
import racingcar.domain.output.Output;
import racingcar.domain.output.OutputMessage;
import racingcar.util.FormatUtil;

public class CarGame {
    private final Cars cars;
    private List<Car> carList;

    private static final String CAR = "자동차";

    public void startCarGame(){
        Output.printMessage(OutputMessage.PLEASE_ENTER_CAR_NAME, CAR);
        List<String> inputs = Input.bringNames(); // 차 이름 가져오기
        carList = cars.changeToCar(inputs); // 차 이름을 차로 변경
        progressCarGame();
    }

    public void progressCarGame(){
        Output.printMessage(OutputMessage.HOW_MANY_TIME);
        int trialAmount = Input.bringTrialAmount();
        Output.printNewLine();
        Output.printMessage(OutputMessage.EXECUTION_RESULT);
        for (int trial = 0; trial < trialAmount; trial++){
            evaluationCarGame();
        }
        List<String> winners = findWinner();
        announceWinner(winners);
    }

    public void evaluationCarGame(){
        for (Car car : carList) {
            car.updateCarDistance();
            String distant = FormatUtil.joinCarsDistances(car.getDistance());
            Output.printResultMessage(OutputMessage.PROGRESS_RESULT, car.getCarName(), distant);
        }
        Output.printNewLine();
    }

    public List<String> findWinner(){
        Optional<Integer> maxDistance = carList.stream()
                .map(Car::getDistance)
                .max(Integer::compare);

        return maxDistance.map(maxDist -> carList.stream()
                        .filter(car -> car.getDistance() == maxDist)
                        .map(Car::getCarName)
                        .collect(Collectors.toList()))
                .orElseGet(Collections::emptyList);
    }

    public void announceWinner(List<String> winnerList){
        String winners = FormatUtil.joinListValues(winnerList);
        Output.printMessage(OutputMessage.FINAL_WINNER, winners);
    }

    public CarGame(Cars cars) {
        this.cars = cars;
    }
}
