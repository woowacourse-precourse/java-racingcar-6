package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
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
        int Num = PutNum();
        RaceStart(Num);
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
    public static int PutNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        String s = Console.readLine();
        int i = Integer.parseInt(s);
        if (i > 0) {
            return Integer.parseInt(s);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public static void RaceStart(int n){
        System.out.println("\n실행 결과");
        for(int i=0;i<n;i++)
        {
            CarMove();
            System.out.println();
        }
    }
    public static void CarMove(){
        for (String key : User.keySet()) {
            if(MoveOrStop())
            {
                User.put(key , User.get(key)+1);
            }
            System.out.print(key + " : ");
            ShowMove(key);

        }
    }
    public static boolean MoveOrStop()
    {
        return 4<=Randoms.pickNumberInRange(0,9);
    }
    public static void ShowMove(String key)
    {
        int i = User.get(key);
        for(int j=0;j<i;j++)
        {
            System.out.print("-");
        }
        System.out.println();
    }
}

