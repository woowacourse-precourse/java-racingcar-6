package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class Round {
    private int roundLength;
    private static final int RANDOM_MAX_INT = 9;
    private static final int RANDOM_MIN_INT = 0;
    private static final int FORWARD_CRITERION = 4;
    private int maxDistance;

    public Round(int roundLength){
        this.roundLength = roundLength;
        this.maxDistance=0;
    }

    public void playRound(ArrayList<Car> carList){
        OutputView outputView = new OutputView();
        outputView.outputFirstLine();
        for(int i=0;i<roundLength;i++){
            for(Car car : carList){
                decisionforward(car);
            }
            outputView.displayResultPerRound(carList);
        }
        ArrayList<Car> carWinnerList = selectWinner(carList);
        outputView.displayWinner(carWinnerList);
    }

    private ArrayList<Car> selectWinner(ArrayList<Car> carList){
        ArrayList<Car> winnerList = new ArrayList<>();
        for(Car car : carList){
            if(maxDistance==car.getRaceLength()){
                winnerList.add(car);
            }
        }

        return winnerList;
    }

    private void decisionforward(Car car){
        if(randomInt()>=FORWARD_CRITERION){
            goForward(car);
        }
    }

    private void goForward(Car car){
        car.plusOneStep();
        if(car.getRaceLength()>maxDistance){
            maxDistance=car.getRaceLength();
        }
    }

    private int randomInt(){
        return Randoms.pickNumberInRange(RANDOM_MIN_INT,RANDOM_MAX_INT);
    }
}
