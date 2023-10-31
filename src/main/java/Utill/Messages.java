package Utill;

import java.util.ArrayList;

public class Messages {
    public static void gameStartMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public static void repeatCountRequestMessage(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void playStartMessage(){
        System.out.println("\n실행 결과");
    }

    public static void playMessage(String[] carsName, String[] carsScoreString){
        for (int i = 0; i < carsScoreString.length; i++) {
            System.out.printf("%s : %s\n",carsName[i], carsScoreString[i]);
        }
        System.out.println();
    }

    public static void gameEndMessage(ArrayList<String> winner){
        System.out.printf("최종 우승자 : %s",String.join(",",winner));
    }

}
