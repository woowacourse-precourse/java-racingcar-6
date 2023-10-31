package racingcar;
import racingcar.Car;
import racingcar.Global;

import java.util.List;
import java.util.Map;
public class Result {
    public void showResult(){
        System.out.println(Global.RACING_RESULT);
    }
    public void showRacingResult(Map<Car, List<Integer>> map, int executeCount){
        for (int i = 0; i < executeCount; i++) {
            final int index=i;
            map.forEach((k,v)->showPosition(k,v.get(index)));
            System.out.println("");
        }
    }
    public void showWinners(List<String> winners){
        String names =String.join(", ",winners);
        System.out.print(Global.RACING_RESULT_ANNOUNCEMENT + names);
    }
    private void showPosition(Car car,int position){
        System.out.print(car.getName()+Global.CAR_BOUNDARY);
        for (int i = 0; i < position; i++) {
            System.out.print(Global.CAR_POSITION);
        }
        System.out.println();
    }
}
