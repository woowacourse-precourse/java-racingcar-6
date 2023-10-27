package racingcar;

import java.util.HashMap;
import java.util.Vector;
import camp.nextstep.edu.missionutils.Console;



public class Utility {
    public static Vector<String> nameVector = new Vector<>();
    public static Integer race_number;
    public static HashMap<String, Integer> nameHash = new HashMap<String, Integer>();
    public static void get_name(){
        String names = Console.readLine();
        String[] name_Arr = names.split(",");
        for(String name : name_Arr){
            //System.out.println(name);
            if(name.length() > 5) throw new IllegalArgumentException("이름의 길이가 깁니다.");
            if(nameHash.containsKey(name.trim())) throw new IllegalArgumentException("중복되는 이름입니다.");
            nameHash.put(name.trim(), 0);
        }
    }
    public static void get_number(){
        try{
            race_number = Integer.parseInt(Console.readLine());
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("유효하지 않은 값입니다. ");
        }

    }
}
