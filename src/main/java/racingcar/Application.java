package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {

    public static HashMap<String, Integer> User = new LinkedHashMap<>();
    public static String[] Name;
    public static int UserNum;
    public static void main(String[] args) {
        game_start();
    }

    public static void game_start(){
        GenCar();
    }

    public static void GenCar(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String s = Console.readLine();
        Name = s.split((","));
        UserNum = Name.length;
        CheckName(s);
        for(int i=0;i<UserNum;i++)
        {
            User.put(Name[i],0);
        }
        for (String key : User.keySet()) {
            System.out.println("KEY : " + key);
        }
    }
    public static void CheckName(String s) {
        for(int i=0;i<UserNum;i++)
        {
            if(Name[i].length()>5||Objects.equals(Name[i], ""))
            {
                throw new IllegalArgumentException();
            }
        }
        if(s.charAt(s.length() - 1)==',') {
            throw new IllegalArgumentException();
        }
    }
}

