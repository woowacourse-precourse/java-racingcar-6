package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Game {
    private Output myOutput;
    private Input myInput;
    private ArrayList<Car> carList;
    public Game(){
        myOutput = new Output();
        myInput = new Input();
        carList = new ArrayList<>();
    }

    public void run(){
        myOutput.printEnterNameOfCar();
        String input = Console.readLine();
        ArrayList<String> carNameList = myInput.getNameList(input);
        for(int i=0; i<carNameList.size(); i++){
            Car myCar = new Car(carNameList.get(i));
            carList.add(myCar);
        }

        myOutput.printEnterTryTime();
        input = Console.readLine();
        int tryCount = Integer.parseInt(input);
        myOutput.printExecutionResult();

        for(int i=0; i<tryCount; i++){

        }
    }

    public void movingALLCar(){
        for(int i=0; i<carList.size(); i++){
            carList.get(i).moving();
        }
    }
}
