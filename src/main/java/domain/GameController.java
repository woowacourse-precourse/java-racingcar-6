package domain;

import domain.InputView.InputNames;
import domain.InputView.InputTurn;
import domain.OutputView.*;

import static message.NoticeMessages.RESULT_MESSAGE;

public class GameController {

    private CarList  carArray;
    private int turnNum;

    public GameController(){
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
        System.out.println(RESULT_MESSAGE);
        for(int i=0; i<turnNum; i++)
        {
            OutputCars.printTurnResult(carArray.turnGoOrStay());
        }

    }

    public void showWinner(){
        OutputWinners.printWinners(carArray.getWinnerNames());
    }

}
