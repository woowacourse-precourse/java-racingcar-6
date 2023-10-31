package racingcar;

import java.util.HashMap;
import java.util.Map;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public String[] carName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carlist = readLine();
        if (!Check.checkCarName(carlist)) throw new IllegalStateException();
        String[] parkingList = carlist.split(",");
        return parkingList;
    }

    public Map<String,Integer> carDistance(String[] carlist) {
        Map<String,Integer> parkingLot = new HashMap<>();;
        for (int i = 0; i < carlist.length; i++) {
            parkingLot.put(carlist[i], 0);
        }
        return parkingLot;
    }

    public int runtime() {
        String time_string = readLine();
        int time_int = 0;
        try {
            time_int = Integer.parseInt(time_string);
        } catch (Exception e) {
            throw new IllegalStateException();
        } finally {
            return time_int;
        }
    }
}
