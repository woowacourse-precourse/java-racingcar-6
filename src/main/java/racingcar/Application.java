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
        ChooseChampion();
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
    }
    public static void CheckName(String s) {
        for(int i=0;i<UserNum;i++)
        {
            if(Name[i].length()>5||Objects.equals(Name[i], "")|| Name[i].isBlank())
            {
                throw new IllegalArgumentException("알맞은 이름을 입력하시오");
            }
        }
        if(s.charAt(s.length() - 1)==',') {
            throw new IllegalArgumentException("알맞은 이름을 입력하시오");
        }
    }
    public static int PutNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            String s = Console.readLine();
            int i = Integer.parseInt(s);
            if (i > 0) {
                return i;
            } else {
                throw new IllegalArgumentException("알맞은 시도 횟수를 입력하시오.");
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("알맞은 시도 횟수를 입력하시오.");
        }
    }

    public static void RaceStart(int n) {
        System.out.println("\n실행 결과");
        for(int i=0;i<n;i++)
        {
            CarMove();
            System.out.println();
        }
    }
    public static void CarMove() {
        for (String key : User.keySet()) {
            if(MoveOrStop())
            {
                User.put(key , User.get(key)+1);
            }
            System.out.print(key + " : ");
            ShowMove(key);
        }
    }
    public static boolean MoveOrStop() {
        return 4<=Randoms.pickNumberInRange(0,9);
    }
    public static void ShowMove(String key) {
        int i = User.get(key);
        for(int j=0;j<i;j++)
        {
            System.out.print("-");
        }
        System.out.println();
    }
    public static void ChooseChampion() {
        int biggest=-1;
        List<String> Winners = new ArrayList<>();
        for (String key : User.keySet()) {
            if (biggest<User.get(key)) {
                biggest=User.get(key);
            }
        }
        for (String key : User.keySet()) {
            if(biggest==User.get(key))
            {
                Winners.add(key);
            }
        }
        PrintChampion(String.join(", ",Winners));
    }
    public static void PrintChampion(String s){
        System.out.println("최종 우승자 : " + s);
    }
}

