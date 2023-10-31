package domain.OutputView;
import java.util.ArrayList;
import java.util.HashMap;

import domain.Car;

public class OutputCars {

    public static void printTurnResult(ArrayList<Car> TurnResult)
    {
        for(Car car : TurnResult)
        {
            System.out.printf("%s : %s%n", car.getName(), printPosition(car.getPosition()));
        }
        System.out.println();

    }

    private static String printPosition(int position){
        String result="";
        for(int i=0; i<position; i++)
        {
            result+="-";
        }
        return result;

    }
}
