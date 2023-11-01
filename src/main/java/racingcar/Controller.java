package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Controller{
    private List<Car> getInputForCarNames(){
        String input=View.getCarNames();
        String[] carNames=input.split(",");
        return createCarFromCarNames(carNames);
    }

    private List<Car> createCarFromCarNames(String[] carNames){
        List<Car> cars=new ArrayList<>();
        for (String carName: carNames){
            if(carName.isEmpty()){
                throw new IllegalArgumentException();
            }
            if(carName.length()>5){
                throw new IllegalArgumentException();
            }
            cars.add(new Car(carName));
        }

        return cars;
    }

    private int getInputForTryCount(){
        String inputForTryCount= View.getTryCount();
        int tryCount;
        try {
            tryCount=Integer.parseInt(inputForTryCount);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }

        if(tryCount<1){
            throw new IllegalArgumentException();
        }

        return tryCount;
    }
    public void startRace(){
        List<Car> cars=getInputForCarNames();
        int tryCount=getInputForTryCount();

        Race race = new Race(cars, tryCount);

        View.printResultAlarm();
        race.conductRace();

        List<String> winners=race.getWinners();
        View.printFinalWinner(String.join(", ", winners));

    }
}
