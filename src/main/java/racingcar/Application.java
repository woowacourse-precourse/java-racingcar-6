package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void inputNameException(String names){
        if(!names.matches("^([\\w]{1,5},)*[\\w]{1,5}$")){
            throw new IllegalArgumentException();
        }
    }

    public static void inputTimeException(String times){
        if(!times.matches("^[0-9]*$"))
            throw new IllegalArgumentException();
    }

    public static String[] inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String str = Console.readLine();
        inputNameException(str);
        String[] names = str.split(",");
        return names;
    }

    public static int inputNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
        String times = Console.readLine();
        inputTimeException(times);
        return Integer.parseInt(times);
    }

    public static void startRacing(String[] names, int times){
        // 자동차의 수
        int number = names.length;
        // 자동차별 전진 횟수 저장
        int[] forward = new int[number];
        Arrays.fill(forward, 0);

        for(int i = 0; i < times; i++) {
            for (int k = 0; k < number; k++) {
                int num = Randoms.pickNumberInRange(0, 9);
                if (num >= 4)
                    forward[k]++;
            }
            // 출력함수
            printRacing(names, forward);
        }

        // 마지막 승자
        winnerCheck(names, forward);

    }

    public static void printRacing(String[] names, int[] forward){
        for(int i = 0; i < names.length; i++){
            System.out.print(names[i] + " : "); // 이름
            for(int k = 0; k < forward[i]; k++)
                System.out.print("-");
            System.out.println("");
        }
        System.out.println("");
    }

    public static void winnerCheck(String[] names, int[] forward){
        int length = forward.length;
        int max = 0;
        List<String> winners = new ArrayList<String>();


        for(int i = 0; i < length; i++){
            if(max < forward[i])
                max = forward[i];
        }

        for(int i = 0; i < length; i++){
            if(max == forward[i])
                winners.add(names[i]);
        }

        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", winners));
    }

    public static void main(String[] args) {

        String names[] = inputCarNames();
        int times = inputNumber();

        startRacing(names, times);
//
//        for(String s : names)
//            System.out.println(s);

    }
}
