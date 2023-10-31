package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Game game = new Game();
        Output output = new Output();

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

            raceCount = game.raceInit(userArray,raceCount);

            game.printRace(userArray,raceCount);


        }

        int max = raceCount[0]; // 배열의 첫 번째 요소를 최대값으로 초기화

        for (int i = 1; i < raceCount.length; i++) {
            if (raceCount[i] > max) {
                max = raceCount[i]; // 더 큰 값을 발견하면 최대값을 업데이트
            }
        }

        ArrayList<String>resultArray = new ArrayList<>();

        resultArray = output.resultSum(resultArray, userArray,raceCount,max);

        output.printresult(resultArray);

    }
}
