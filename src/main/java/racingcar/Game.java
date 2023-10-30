package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Game {
    private Output myOutput;
    private Input myInput;

    public Game(){
        myOutput = new Output();
        myInput = new Input();
    }
    public void run(){
        myOutput.printEnterNameOfCar();
        String input = Console.readLine();
        ArrayList<String> carNameList = myInput.getNameList(input);


        myOutput.printEnterTryTime();
    } 
}
