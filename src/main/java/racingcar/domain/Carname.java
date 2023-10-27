package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Carname {
    public List<String> name(){
        List<String > carname = new ArrayList<>();
        String input = Console.readLine();
        String[] inputsplit = input.split(",");
        for(int i=0;i<inputsplit.length;i++){
            if(inputsplit[i].length() > 5) throw new IllegalArgumentException();
            carname.add(inputsplit[i]);
        }
        return carname;
    }
}
