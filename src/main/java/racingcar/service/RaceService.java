package racingcar.service;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.domain.Cars;
public class RaceService {
    Cars cars;
    public void ParticipateRace(){
        String InputCars = Console.readLine();
        cars = new Cars(splitCarNames(InputCars));
    }

    public static String[] splitCarNames(String InputCars){
        String[] splitCarNames;
        splitCarNames = InputCars.split(",");
        return splitCarNames;
    }
}
