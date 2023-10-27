package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DataInputOutput {
    private static List<Car> carList = new ArrayList<Car>();
    public void userInputCarsInfo(){
        // Validate Here
        StringTokenizer tokenizer = new StringTokenizer(Console.readLine(), ",");
        // Validate Here
        while(tokenizer.hasMoreTokens()){
            Car newCar = new Car();
            newCar.makeCar(tokenizer.nextToken());
            carList.add(newCar);
        }
    }
    public void userInputMovingInfo(){}
    public void printSystemMessage(){}
    public void printMovingResult(){}
    public void makeRandomNumber(){}
}
