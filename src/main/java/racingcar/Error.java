package racingcar;

import java.util.InputMismatchException;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Error {
    Error(){}
    public static boolean checkNameLength(String name){
        String [] list = name.split(",");
        for (int i = 0; i < list.length; i++) {
            if(list[i].length()>Global.CAR_NAME_LIMIT){
                return false;
            }
        }
        return true;
    }
    public void inputRight(){
        try{
            String carInput = readInput();
        }catch(InputMismatchException e){
            inputRight();
        }

    }
    private String readInput(){

        String input = readLine();
        return input;
    }
}
