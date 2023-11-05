package racingcar.game;

import racingcar.car.Car;
import racingcar.user.User;

import java.util.ArrayList;
import java.util.List;

public class Game {
    User user = new User();
    public void GameSet(){
        List<String> carList = user.carNameInput();
        List<Car> carList1 = new ArrayList<>();
        for (String i:carList) {
            carList1.add(new Car(i,0));
        }
        int round = user.gameRoundInput();
        for(int i=0;i<round;i++){
            carList1=OneRoundScore(carList1);
            user.gameRoundOutput(carList1);
        }
        int winnerScore = findMaxScore(carList1);
        List<String> winner = winner(carList1,winnerScore);
        user.gameWinnerOutput(winner);
    }
    public List<Car> OneRoundScore(List<Car> carList){
        List<Car> update=new ArrayList<>();
        for(Car i:carList){
            i.oneStep();
            update.add(i);
        }
        return update;
    }
    public int findMaxScore(List<Car> carList){
        int max=0;
        for(Car i : carList){
            if(max<i.getScore()){
                max=i.getScore();
            }
        }
        return max;
    }
    public List<String> winner(List<Car> carList,int maxScore){
        List<String> winnerList = new ArrayList<>();
        for(Car i:carList){
            if (maxScore == i.getScore()){
                winnerList.add(i.getName());
            }
        }
        return winnerList;
    }
}
