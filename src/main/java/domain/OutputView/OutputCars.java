package domain.OutputView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import domain.Car;

public class OutputCars {

    public static void printTurnResult(HashMap<String, Integer> TurnResult)
    {
        for(Map.Entry<String, Integer> entry : TurnResult.entrySet())
        {
            System.out.printf("%s : %s%n", entry.getKey(), printPosition(entry.getValue()));
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
