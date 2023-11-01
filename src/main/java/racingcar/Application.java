package racingcar;

import java.util.ArrayList;
import java.util.Collections;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

class Car{
    String Car_name;
    int score = 0;

    Car(String name){
        this.Car_name = name;
    }

    void randomTest(){
        int randomICT = Randoms.pickNumberInRange(0,9);
        if(randomICT >= 4){
            this.score++;
        }
    }

    String scoreRepresent(){
        randomTest();
        String represent = "";
        for(int i =0; i < this.score; i++){
            represent += "-";
        }
        return represent;
    }
}


class Game{
    String START_MENTS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    String TRY_ASK_MENTS = "시도할 회수는 몇회인가요?";

    String[] carNameList;

    Car[] carlist;

    int chance;

    void init(){
        System.out.println(START_MENTS);
        String strStream = Console.readLine();
        String[] carNameList = strStream.split(",");
        if(!Check(carNameList)){
            throw new IllegalArgumentException();
        }
        System.out.println(TRY_ASK_MENTS);
        String chanceCheck = Console.readLine();
        chance = Integer.parseInt(chanceCheck);
    }

    void realGame(){
        carlist = new Car[carNameList.length];

        for(int i = 0; i < carNameList.length; i++){
            carlist[i] = new Car(carNameList[i]);
        }

        for(int i = 0; i < chance; i++){
            System.out.println();
            System.out.println("실행결과");
            for(int j =0; j < carNameList.length;j++){
                System.out.println(carlist[j].Car_name + " : " + carlist[j].scoreRepresent());
            }
        }
        winner();
    }

    boolean Check(String[] str){
        for(int i = 0; i < str.length; i++){
            if (str[i].length() > 5){
                return false;
            }
        }
        return true;
    }

    void winner(){
        ArrayList<Integer> scores = new ArrayList<>();
        for(int i = 0; i< carNameList.length; i++){
            scores.add(carlist[i].score);
        }
        int maxValue = Collections.max(scores);

        ArrayList<Integer> winner = new ArrayList<>();


        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) == maxValue) {
                winner.add(i);
            }
        }

        if(winner.size() == 1){
            System.out.println("최종 우승자 : " + carlist[winner.get(0)].Car_name);
        }
        else{
            for(int i = 0; i < winner.size(); i++){
                System.out.println("최종 우승자 : " + carlist[winner.get(i)].Car_name);
            }
        }

    }
}



public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.realGame();
    }
}
