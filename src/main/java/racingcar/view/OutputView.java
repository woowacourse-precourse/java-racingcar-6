package racingcar.view;

import racingcar.model.Car;
import racingcar.model.GameState;
import racingcar.model.GameViewMessage;

import java.util.ArrayList;

public class OutputView {

    public void displayResultPerRound(GameState gameState){
        StringBuilder sb = new StringBuilder();
        for(String carName : gameState.getCarStateMap().keySet()){
            String stepDistance = gameState.getCarStateMap().get(carName);
            sb.append(carName).append(colonWithSpaceBar()).append(stepDistance).append("\n");
        }
        System.out.println(sb);
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

    private String colonWithSpaceBar(){
        String colon = GameViewMessage.spaceBar.getMessage();
        colon += GameViewMessage.colonString.getMessage();
        colon += GameViewMessage.spaceBar.getMessage();
        return colon;
    }

    private String colonString(){
        return GameViewMessage.colonString.getMessage();
    }

    
    public void outputFirstLine(){
        System.out.println(GameViewMessage.outputFirstLineMessage.getMessage());
    }



    private String winnerMessage(){
        return GameViewMessage.outputWinnerMessage.getMessage();
    }
}
