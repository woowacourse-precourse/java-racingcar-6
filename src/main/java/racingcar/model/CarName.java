package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.StringTokenizer;
import java.util.ArrayList;


public class CarName {
    static String carNames;
    static ArrayList<String> carList= new ArrayList<>();
    public void InputCarNames(){
        carNames = Console.readLine();
    }

    public void CarNamesToList(){
        StringTokenizer cars = new StringTokenizer(carNames,",");
        while(cars.hasMoreTokens()){
            carList.add(cars.nextToken());
        }
    }
}
