package domain;
import java.util.List;
import validate.ValidateGo;
import static constant.GameUserInterface.*;

public class GameOutput {


//    public static void

    public static void carNameOutput(String carname){
        System.out.print(carname + CAR_NAME_COLON.getUserInterface());

    }
    public static void carDistance(String distance){
        System.out.println(" "+distance);
    }

    public static void gameResult(String Winner){
        System.out.print( RACING_WINNER.getUserInterface()
                + CAR_NAME_COLON.getUserInterface()
                + " "
                + Winner);
    }



}
