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
            if (name.length() <= 5){
                inputCarName.add(name);
            } else {
                throw new IllegalArgumentException("5글자 이하만 입력하시오");
            }
        }

        System.out.println(inputCarName);
        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = inputTryNumber();
        System.out.println(tryNumber);

        int go = Randoms.pickNumberInRange(0,9);
        System.out.println(go);
        if (go >= 4){
            System.out.println("pobi : ");
            System.out.println("woni : ");
            System.out.println("jun : ");
        }



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
