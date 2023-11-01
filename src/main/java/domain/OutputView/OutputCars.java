package domain.OutputView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import domain.Car;

public class OutputCars {

    public static void printTurnResult(ArrayList<Car> carList)
    {
        for(Car car : carList)
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
