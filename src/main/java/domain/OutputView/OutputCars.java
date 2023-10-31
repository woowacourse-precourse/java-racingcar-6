package domain.OutputView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import domain.Car;

public class OutputCars {

    public static void printTurnResult(HashMap<String, String> TurnResult)
    {
        for(Map.Entry<String, String> entry : TurnResult.entrySet())
        {
            System.out.printf("%s : %s%n", entry.getKey(), entry.getValue());
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
