package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.View.InputView;
import racingcar.View.OutputView;
import racingcar.model.Car;
import racingcar.model.Cars;

public class RacingGame {
    private static final int MIN_NUM_RANGE = 1;
    private static final int MAX_NUM_RANGE = 9;
    private static final int CRITERION = 4;
    private int numRound;

    private final Cars cars = new Cars();

    public void play(){
        setCars();
        setNumRound();

        OutputView.printGameResultMessage();
        for (int i =0 ; i<numRound ; i++){
            race();
            OutputView.printCarsResult(cars);
            System.out.println();
        }
        int maxPosition = getMaxPosition();
        List<String> winners = getWinners(maxPosition);

        OutputView.printWinners((ArrayList<String>) winners);
    }

    public void setCars() {
        InputView.printStartGuideMessage();
        String names = InputView.getCarNames();
        cars.addCar(names);
    }

    public void setNumRound() {
        InputView.printRoundGuideMessage();
        String input = InputView.getNumRound();
        numRound = Integer.parseInt(input);
    }

    public void race(){
        for (Car car : cars.getCarList()){
            if (Randoms.pickNumberInRange(MIN_NUM_RANGE, MAX_NUM_RANGE) >= CRITERION){
                car.move();
            }
        }
    }

    public int getMaxPosition(){
        List<Integer> carPositionList = new ArrayList<Integer>();
        for (Car car : cars.getCarList()){
            carPositionList.add(car.genPosition());
        }
    return Collections.max(carPositionList);
    }

    public List<String> getWinners(int maxPosition){
        List<String> winnersList = new ArrayList<String>();
        for (Car car : cars.getCarList()){
            if(maxPosition == car.genPosition()){
                winnersList.add(car.getName());
            }
        }
        return winnersList;
    }
}
