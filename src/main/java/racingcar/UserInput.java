package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public String[] inputCarName(){
        String input = Console.readLine();
        String[] carName = input.split(", ");
        return carName;
    }

    public int inputCount(){
        String input = Console.readLine();
        int number = -1;
        try{
            number = Integer.parseInt(input);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        return number;
    }
}
