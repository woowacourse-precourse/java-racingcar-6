package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = View.getCarNames();
        String[] carNames=input.split(",");
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

        View.printResultAlarm();

        Race race = new Race(cars, tryCount);
        race.conductRace();
        List<String> winners=race.getWinners();
        View.printFinalWinner(String.join(", ", winners));
    }
}
