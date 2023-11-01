package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Controller{
    private Race race;
    private List<Car> getInputForCarNames(){
        String input=View.getCarNames();
        String[] carNames=input.split(",");
        return createCarFromCarNames(carNames);
    }

    private void validateCarName(String carName){
        if(carName.isEmpty()){
            throw new IllegalArgumentException();
        }
        if(carName.length()>5){
            throw new IllegalArgumentException();
        }
    }

    private List<Car> createCarFromCarNames(String[] carNames){
        List<Car> cars=new ArrayList<>();
        for (String carName: carNames){
            validateCarName(carName);
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void validateTryCount(int tryCount){
        if(tryCount<1){
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    private int parseToInteger(String tryCount){
        try {
            return Integer.parseInt(tryCount);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    private int getInputForTryCount(){
        String inputForTryCount= View.getTryCount();
        int tryCount = parseToInteger(inputForTryCount);
        validateTryCount(tryCount);

        return tryCount;
    }

    public void prepareRace(){
        List<Car> cars=getInputForCarNames();
        int tryCount=getInputForTryCount();

        race = new Race(cars, tryCount);
    }

    public void startRace(){
        View.printResultAlarm();
        race.conductRace();
    }

    public void announceResult(){
        List<String> winners=race.getWinners();
        View.printFinalWinner(String.join(", ", winners));
    }
}
