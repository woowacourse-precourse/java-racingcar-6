package domain;
import camp.nextstep.edu.missionutils.Console;
import exceptional.ExceptionalTry;
import java.util.Arrays;
import java.util.List;
import validate.ValidateNameInRange;

public class GameInput {

    public static int userGameTries(){
        String Tries = Console.readLine();
        //정규식 0-9로만 이루어져있는지
        if(Tries.matches("[0-9]+")){
            ExceptionalTry.exception();
        }
        Console.close();
        return Integer.parseInt(Tries);
    }

    public static List<String> userCarNameInput(){
        String strCarName = Console.readLine();
        List<String> CarNames = NameSplit(strCarName);
        Console.close();
        return ValidateNameInRange.NameInRange(CarNames);
    }
    private static List<String> NameSplit(String strCarName){
        List<String> CarNames = Arrays.stream(strCarName.split(",")).toList();
        return CarNames;

    }

}
