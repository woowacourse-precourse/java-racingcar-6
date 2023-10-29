package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingData;
import racingcar.view.RacingGameOutputs;

import java.util.ArrayList;
import java.util.List;

public class VictoryCondition {

    RacingData racingData = RacingData.getInstance();
    Car car = Car.getInstance();


    public int mostFar (){

        int mostFarDistance =0;

        for (int i = 0; i < racingData.getForwardPointList().size(); i++) {

            if(racingData.getForwardPointList().get(i) >= mostFarDistance ){
                mostFarDistance = racingData.getForwardPointList().get(i);
            }
        }

        return mostFarDistance;
    }

    public int winnerNumber() {

        int winners = 0;

        for (int i = 0; i < racingData.getForwardPointList().size(); i++) {

            if (racingData.getForwardPointList().get(i) == mostFar()) {
                winners++;
            }
        }

        return winners;
    }

    public void makeWinnerList() {

        List<String> winnerList = new ArrayList<>();

        for (int i = 0; i < car.getPassedTestList().size(); i++) {

            if(racingData.getForwardPointList().get(i) == mostFar()){
                winnerList.add(car.getPassedTestList().get(i));
            }
        }

        racingData.setWinnerList(winnerList);
    }

    public void winnerIs(int winnerNumber) {

        if (winnerNumber() == 1){
            soloWinner();
        }

        if(winnerNumber() > 1) {
            multiWinner();
       }
    }


    public void soloWinner() {

        System.out.print(RacingGameOutputs.finalWinner + racingData.getWinnerList().get(0));

    }

    public void multiWinner() {

        System.out.print(RacingGameOutputs.finalWinner);
        multiWinnerOutputForm();

    }

    public void multiWinnerOutputForm(){

        for (int i= 0; i < racingData.getWinnerList().size(); i++) {

            System.out.print(racingData.getWinnerList().get(i));

            if (i != (racingData.getWinnerList().size())-1) {
                System.out.print(", ");
            }
        }
    }


}
