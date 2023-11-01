package racingcar.domain;
import java.util.HashMap;
import java.util.List;

public class Play {

    public void PlayGame(){

        Input input = new Input();
        Output output = new Output();
        Calculate cal = new Calculate();

        List<String> carNames = input.getCarName();
        int gameCount = input.getCountYouWantTry();
        HashMap<String,Integer> racers = cal.MappingNameAndCar(carNames);
        for(int i=0; i< gameCount; i++){
            racers = cal.setCarPosition(racers);
            output.printCarPosition(racers);
            System.out.println();
        }
        output.printFinalWinner(racers);
    }



}
