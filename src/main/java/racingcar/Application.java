package racingcar;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    static Racer[] racers;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int player_n, i, j, n;
        int winnerDistance;
        String input;
        String[] names;

        TException te = new TException();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        input = Console.readLine();
        names = input.split(",");
        player_n = names.length;

        if(player_n == 0)
            te.shoot();

        racers = new Racer[player_n];

        System.out.println("시도할 회수는 몇회인가요?");
        n = Integer.parseInt(Console.readLine());

        if(n<0){
            te.shoot();
        }

        for(i=0;i<player_n;i++){
            if(names[i].length() > 6){
                te.shoot();
            }
            racers[i] = new Racer(names[i]);
        }

        for(i=0;i<n;i++){
            for(j=0;j<player_n;j++) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    racers[j].forward();
                }
            }
            printRacers(player_n);
        }

        winnerDistance = getMaxDistance(player_n);

        System.out.print("최종 우승자 : ");
        for(i=0;i<player_n;i++) {
            if (racers[i].getDistance() == winnerDistance) {
                System.out.print(racers[i].getName() + ", ");
            }
        }
        System.out.println("\b\b");
    }

    static int getMaxDistance(int player_n){
        int i;
        int maxDistance = -1;
        for(i=0;i<player_n;i++){
            if(racers[i].getDistance() > maxDistance){
                maxDistance = racers[i].getDistance();
            }
        }
        return maxDistance;
    }

    static void printRacers(int player_n){
        int i, j;
        for(i=0;i<player_n;i++){
            System.out.print(racers[i].getName() + " : ");
            for(j=0;j<racers[i].getDistance();j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

}

class Racer{
    String name;
    int distance;

    public Racer(String name){
        this.name = name;
    }
    public void forward(){
        this.distance++;
    }

    public int getDistance(){
        return this.distance;
    }

    public String getName(){
        return this.name;
    }
}

class TException{
    public void shoot() throws IllegalArgumentException{
        throw new IllegalArgumentException();
    }
}