package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class game {
    car[] participate;
    int try_number;

    String[] input_name(String name_bundle){ //자동차 이름 분류
        String[] names = name_bundle.split(",");

        return names;
    }

    void store_name(){ //자동차 이름 저장
        String name_bundle;
        String[] names;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        name_bundle = readLine();
        names = input_name(name_bundle);

        participate = new car[names.length];
        for(int i = 0; i < names.length; i++){
            participate[i] = new car(names[i], 0);
        }
    }

    void input_trynumber(){ //시도 횟수 입력
        System.out.println("시도할 회수는 몇회인가요?");
        try_number = Integer.parseInt(readLine());
    }


}
