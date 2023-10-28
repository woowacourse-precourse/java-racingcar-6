package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Application {

    public static String[] inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String str = Console.readLine();
        String[] names = str.split(",");
        return names;
    }

    public static int inputNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
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

    public static void main(String[] args) {

        String names[] = inputCarNames();
        int times = inputNumber();

        startRacing(names, times);
//
//        for(String s : names)
//            System.out.println(s);

    }
}
