package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DataInputOutput {
    private static List<Car> carList = new ArrayList<Car>();
    private static int numTotalMoving;
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
    public void userInputMovingInfo(){
        String userInput = Console.readLine();
        //Validate Here
        numTotalMoving = Integer.parseInt(userInput);
    }
    public void printSystemMessage(){}
    public void printMovingResult(){}
    public void makeRandomNumber(){}
}
