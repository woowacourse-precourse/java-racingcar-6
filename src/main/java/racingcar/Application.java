package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static int max=-1;
    static String winner="";
    public static void main(String[] args) {
        String[] cars_name;
        Integer[] cars_race;
        int n, i;
        String input;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        input=Console.readLine();
        cars_name=input.split(",");
        cars_race=new Integer[cars_name.length];
        for(i=0;i<cars_race.length;i++){
            cars_race[i]=0;
            if(cars_name[i].length()>5){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
        System.out.println("시도할 회수는 몇회인가요?");
        n=Integer.parseInt(Console.readLine());
        if(n>=0&&n<=2147483647){
            System.out.println("\n실행 결과");
            for (i = 0; i < n; i++) {
                racing(cars_name, cars_race);
                System.out.println();
            }
            for (i = 0; i < cars_name.length; i++) {
                win(cars_name[i], cars_race[i]);
            }
            System.out.println("최종 우승자 : " + winner);
        }else{
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
    public static void racing(String[] name, Integer[] race){
        for(int i=0;i<name.length;i++){
            if(Randoms.pickNumberInRange(0,9)>=4)race[i]+=1;
        }
        for (int i=0;i<name.length;i++){
            System.out.print(name[i] + " : ");
            road(race[i]);
            System.out.println();
        }
    }
    public static void road(Integer race){
        for(int i=0;i< race;i++)System.out.print("-");
    }
    public static void win(String name, Integer road){
        if(road>max){
            max=road;
            winner=name;
        } else if(road==max){
            winner=winner+", "+name;
        }

    }
}
