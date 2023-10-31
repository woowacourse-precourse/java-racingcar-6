package racingcar;

import java.util.Map;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public Map<String, Integer> carName(){
        Map<String,Integer> parkingLot = null;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carlist = readLine();
        if(!Check.checkCarName(carlist)) throw new IllegalStateException();
        // carDistance 넣어서 거리 0으로 초기화
        return parkingLot;
    }

    public Map<String,Integer> carDistance(Map<String,Integer> parkingLot,String carlist) {
        String[] car_list = carlist.split(",");
        for (int i = 0; i < car_list.length; i++) {
            parkingLot.put(car_list[i],0);
        }
        return parkingLot;
    }

}
