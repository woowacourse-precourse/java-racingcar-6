package domain;

import domain.InputView.InputNames;
import domain.InputView.InputTurn;
import domain.OutputView.*;

public class RacingController {

    private CarList  carArray;
    private int turnNum;

    public RacingController(){
        setCars();
        setTurnNum();
        play();
        showWinner();
    }

    public void setCars(){
        try{
            String [] nameArray= InputNames.carInput();
            carArray = new CarList(nameArray);
        }catch(IllegalArgumentException e){
            e.getMessage();
        }

    }

    public void setTurnNum(){
        try{
            this.turnNum = InputTurn.turnInput();

        }catch(IllegalArgumentException e){
            e.getMessage();
        }
    }

    public void play(){
        System.out.println("실행결과");
        for(int i=0; i<turnNum; i++)
        {
            OutputCars.printTurnResult(carArray.turnGoOrStay());
        }

    }

    public void showWinner(){
        OutputWinners.printWinners(carArray.getWinnerNames());
    }

}
