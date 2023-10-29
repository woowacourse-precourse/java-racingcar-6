package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.view.ResultView;
import racingcar.view.SettingView;

import java.util.ArrayList;

public class GameController {
    private static final ArrayList<Car> carList = new ArrayList<>();
    private static int round;

    public void setGame(){
        setCars();
        setRoundNumber();
        System.out.println();
    }

    public void printResults(){
        ResultView.printResultTitle();
        for(int r=0; r<round; r++){
            printResultOfRound();
        }
    }

    public void printWinner(){
        ArrayList<String> winnerNameList = getWinnerNameList();
        ResultView.printWinner(winnerNameList);
    }

    public static void setCars(){
        SettingView.printInputCarNameMsg();
        String carNames = Console.readLine();
        // TODO : valid check
        setCarList(carNames);
    }

    public static void setRoundNumber(){
        SettingView.printInputRoundNumberMsg();
        String roundNumber = Console.readLine();
        // TODO : valid check
        round = Integer.parseInt(roundNumber);
    }

    public void printResultOfRound(){
        for(Car car : carList){
            if(Randoms.pickNumberInRange(0,9)>=4){
                car.move();
            }
            ResultView.printCarState(car.name, car.position);
        }
        System.out.println();
    }

    public ArrayList<String> getWinnerNameList(){
        ArrayList<String> winnerNameList = new ArrayList<>();
        int max = 0;
        for(Car car : carList){
            if(car.position>max) {
                max = car.position;
                winnerNameList.clear();
            }
            if(car.position==max){
                winnerNameList.add(car.name);
            }
        }
        return winnerNameList;
    }

    public static void setCarList(String carNames){
        for(String carName : carNames.split(",")){
            carList.add(new Car(carName));
        }
    }
}
