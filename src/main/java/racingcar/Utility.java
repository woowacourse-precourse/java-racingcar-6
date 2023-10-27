package racingcar;

import java.util.Vector;
import camp.nextstep.edu.missionutils.Console;



public class Utility {
    public static Vector<String> nameVector = new Vector<>();
    public static void get_name(){
        String names = Console.readLine();
        String[] name_Arr = names.split(",");
        for(String name : name_Arr){
            //System.out.println(name);
            nameVector.add(name.trim());
        }
    }
}
