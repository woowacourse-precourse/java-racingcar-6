package domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputUser {
    public List<String> getNames(String userInput){
        List<String> names = new ArrayList<>(Arrays.asList(userInput.split(",")));
        for(int i=0;i<names.size();i++){
            if(names.get(i).length()>5){
                throw new IllegalArgumentException();
            }
        }
        return names;
    }
    public int getNumber(){
        try {
            int getNum = Integer.parseInt(Console.readLine());
            return getNum;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }

    }
}
