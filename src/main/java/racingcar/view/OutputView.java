package racingcar.view;

import racingcar.model.Car;
import racingcar.model.GameViewMessage;

import java.util.ArrayList;

public class OutputView {

    public void displayResultPerRound(ArrayList<Car> carList){
        StringBuilder sb = new StringBuilder();
        for(Car car : carList){
            sb.append(car.getCarName()).append(colonWithSpaceBar()).append(car.totalDistance()).append("\n");
        }
        sb.append("\n");
        System.out.print(sb);
    }

    public void displayWinner(ArrayList<Car> carWinnerList){
        StringBuilder sb = new StringBuilder();
        sb.append(winnerMessage()).append(colonWithSpaceBar());
        for(Car car : carWinnerList){
            sb.append(car.getCarName()).append(colonString());
        }

        //끝 부분 삭제
        int sbEndIndex = sb.length();
        int sbStartIndex = sbEndIndex - colonString().length();
        sb.delete(sbStartIndex,sbEndIndex);
        System.out.println(sb);
    }

    public String colonWithSpaceBar(){
        String colon = GameViewMessage.spaceBar.getMessage();
        colon += GameViewMessage.colonString.getMessage();
        colon += GameViewMessage.spaceBar.getMessage();
        return colon;
    }

    public String colonString(){
        return GameViewMessage.colonString.getMessage();
    }

    
    public void outputFirstLine(){
        System.out.println(GameViewMessage.outputFirstLineMessage.getMessage());
    }



    public String winnerMessage(){
        return GameViewMessage.outputWinnerMessage.getMessage();
    }
}
