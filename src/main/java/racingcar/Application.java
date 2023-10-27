package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<String> inputCarName = new ArrayList<>();
        String input = Console.readLine();
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() <= 5) {
                inputCarName.add(name);
            } else {
                throw new IllegalArgumentException("5글자 이하만 입력하시오");
            }
        }

        System.out.println(inputCarName);
        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = inputTryNumber();
        System.out.println(tryNumber);

        int[] scores = new int[inputCarName.size()];
        for (int j = 0; j < tryNumber; j++) {
            for (int i = 0; i < inputCarName.size(); i++) {
                int go = Randoms.pickNumberInRange(0, 9);
                if (go >= 4) {
                    scores[i]++;
                }
            }
            for (int i = 0; i < inputCarName.size(); i++) {
                System.out.println(inputCarName.get(i)+ " : " + scores[i]);
            }
            System.out.println();
        }

        int max = scores[0];
        for (int i = 0; i < scores.length; i++) {
            if(scores[i] > max) {
                max = scores[i];
            }
        }
        System.out.println(max);

        // TODO : 1max와 같은 점수를 가진 사람이름을 출력해보시오. 2스코어점수를 막대로 표현하기

    }


    private static int inputTryNumber(){
        try{
            int tryNumberInt = Integer.parseInt(Console.readLine());
            if (tryNumberInt <= 0) {
                throw new IllegalArgumentException("양수를 입력하시오");
            }
            return tryNumberInt;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력하시오");
        }
    }
}
