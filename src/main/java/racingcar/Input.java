package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public static List<Integer> carname_input() {
        List<Integer> carlist = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputcar = Console.readLine();


        String[] temp = inputcar.split(",");

        for(int i =0; i<inputcar.length(); i++){
            if(temp[i].length() >5){
                throw new IllegalArgumentException();
            }
            carlist.add(Integer.parseInt(temp[i]));
        }
        return carlist;
    }

    public static int howmanymove(){
        System.out.println("시도할 회수는 몇회인가요?");

        int movecnt = Integer.parseInt(Console.readLine());

        return movecnt;

    }

}
