package racingcar;

import java.util.Map;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    public Map<String, Integer> carName() {
        Map<String, Integer> parkingLot = null;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carlist = readLine();
        if (!Check.checkCarName(carlist)) throw new IllegalStateException();
        parkingLot = carDistance(parkingLot, carlist);
        return parkingLot;
    }

    public Map<String,Integer> carDistance(Map<String,Integer> parkingLot,String carlist) {
        String[] car_list = carlist.split(",");
        for (int i = 0; i < car_list.length; i++) {
            parkingLot.put(car_list[i], 0);
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
