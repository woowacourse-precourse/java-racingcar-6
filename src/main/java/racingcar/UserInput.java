package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    int count;
    String[] CarNames;
    UserInput(){
        generateCarNames();
        askCount();
    }

    void generateCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String CarName = Console.readLine();
        CarNames = CarName.split(",");

        int length = CarNames.length;

        if(length > 5){
            throw new IllegalArgumentException("자동차의 이름은 5자 이하이어야 합니다.");
        }
        else{
            generateCarNames();
        }
    }

    void askCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        count = Integer.parseInt(Console.readLine());
    }
}
