package domain;


import static constant.GameUserInterface.*;
import static domain.CarDrive.*;


import domain.Car;
import domain.GameInput;


import java.util.List;
//import static 해야지 enum 가져올 수 있음

public class GameControl {
    private GameControl(){

    }

    public static void start(){

        System.out.println(ASK_CAR_NAME.getUserInterface());
        List<String> carNames = GameInput.userCarNameInput();

        System.out.println(ASK_GAME_TRYS.getUserInterface());
        int tries = GameInput.userGameTries();

        System.out.println(RACING_RESULT.getUserInterface());
        //car에서 => carNameOutput() => carDistance() 입력순
        getCarNames(carNames);
        driving(tries);


    }

    public static void stop(){

        GameOutput.gameResult(CarDrive.Winner());
        GameInput.inputStop();
    }

}
