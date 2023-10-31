package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputController {

    public static String[]carNamesArray;
    public static ArrayList<Car>carArrList;
    public static int cycleNum;

    public InputController() {
        carNamesArray= new String[0];
        carArrList= new ArrayList<>();
        cycleNum= 0;
    }

    void inputCarName() {
        PrintController.printCarNameDirection();
        String carNames =readLine();
        carNamesArray= carNames.split(",", -1);

        ArrayList<String> carNamesList = new ArrayList<>(Arrays.asList(carNamesArray));

        for (String carName :carNamesArray) {
            carArrList.add(new Car(carName));
        }
    }

    void inputCycleNum() {
        PrintController.printCycleNumDirection();
        String stringCycleNum =readLine();
        cycleNum= Integer.parseInt(stringCycleNum);
    }
}
