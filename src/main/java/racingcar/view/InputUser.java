package racingcar.view;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.InputException;
import racingcar.model.Car;
import racingcar.model.GameState;
import racingcar.model.GameViewMessage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

//Randoms.pickNumberInRange(RANDOM_MIN_INT,RANDOM_MAX_INT);
public class InputUser {
    private String carNameString;
    private String inputRoundLength;
    private ArrayList<String> carNameArray;
    private static final int RANDOM_MAX_INT = 9;
    private static final int RANDOM_MIN_INT = 0;
    private static final String SEPARATOR = ",";
    private InputException inputException;


    public InputUser(){
        this.carNameString="";
        this.inputRoundLength="";
        this.carNameArray=null;
        this.inputException = new InputException();
    }

    public void inputCarNameString() {
        displaywriteCarNameMessage();
        carNameString = Console.readLine();
        carNameArray = splitToArray(carNameString);
        //Exception 확인

    }

    public ArrayList<Car> returnCar() {
        ArrayList<Car> carArrayList = new ArrayList<>();
        for (String carName : carNameArray){
            carArrayList.add(new Car(carName));
        }
        return carArrayList;
    }

    private ArrayList<String> splitToArray(String carNameString){
        return new ArrayList<>(Arrays.asList(carNameString.split(SEPARATOR)));
    }

    public int inputRoundLength(){
        displaywriteRaceLengthMessage();
        inputRoundLength=Console.readLine();
        //Exception
        return Integer.parseInt(inputRoundLength);
    }

    private void displaywriteCarNameMessage(){
        System.out.println(GameViewMessage.writeCarNameMessage.getMessage());
    }

    private void displaywriteRaceLengthMessage(){
        System.out.println(GameViewMessage.writeRaceLengthMessage.getMessage());
    }

}
