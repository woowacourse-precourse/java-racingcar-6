package racingcar;

public class Controller {

    private Race race;
    private View raceView = new View();

    private String[] splitCarNames(String carNameInput){
        String[] carNames = carNameInput.split(",");
        for(int i=0; i<carNames.length;i++){
            carNames[i] = carNames[i].trim();
        }
        return carNames;
    }

    public void startRace(){

    }
}
