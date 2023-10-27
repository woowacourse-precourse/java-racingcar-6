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
        String carNameInput = raceView.printStartMeg();
        String [] carNames = splitCarNames(carNameInput);

        this.race = new Race(carNames);

        int countNumber = raceView.printGoCount();
        raceView.printResultMeg();

        for(int i=0; i<countNumber; i++){
            for(int j=0; j<carNames.length; j++){
                race.moveCars(carNames[j]);
            }
            raceView.printRaceResult(race.getCars());
        }
    }
}
