package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Service {
    static String[] getCarNamesFromUser(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    static int getTryCountFromUser(){
        System.out.println("시도할 회수는 몇회인가요?");
        try{
            return Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("잘못된 입력입니다. 회수는 숫자로 입력해주세요.");
        }
    }
}
