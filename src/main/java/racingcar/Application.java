package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();

        ArrayList<String>userArray = Input.inputUser();
        // 자른 문자열을 ArrayList에 저장

        int[] raceCount = new int[userArray.size()];

        for (int i = 0; i < raceCount.length; i++) {
            raceCount[i] = 0;
        }
        //racecount를 다 0으로 초기화

        System.out.println("시도할 회수는 몇회인가요?");
        String countStr = Console.readLine();
        int count = Integer.parseInt(countStr);

        for(int i = 0; i < count;i++){

            for(int k = 0 ; k < userArray.size(); k++){
                int raceNumber = Randoms.pickNumberInRange(0,9);
                if (raceNumber >= 4){
                    raceCount[k]++;

                }
            }

            for (int a = 0 ; a < userArray.size();a++){

                System.out.print(userArray.get(a)+" : ");
                for (int j = 0; j < raceCount[a]; j++) {
                    System.out.print("-");
                }
                System.out.println();
            }


        }



    }
}
