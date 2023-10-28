package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Racingcar_Game {
    public static List<String> userInput(){
        List<String> carName = new ArrayList<>();

        String input=readLine();
        String name="";

        for(int i =0;i<input.length();i++){
            if(input.charAt(i)==','){
                if(checkNameLength(name)){
                    carName.add(name);
                    name="";
                };
            }
            else name+=input.charAt(i);
        }
        carName.add(name);

        return carName;
    }

    public static boolean checkNameLength(String name){
        if(name.length() > 5)
            throw new IllegalArgumentException("Name is too long");
        return true;
    }
}
