package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Map;

public class Car {
    private boolean CanRun(){
        int dice = Randoms.pickNumberInRange(0, 9);

        if(dice >= 4){
            return true;
        }

        return false;
    }

    public void run(int count, List<String> names, Map<String, Integer> cars){
        for(int i =0;i<count;i++){
            for(String name: names) {
                if (CanRun()) {
                    cars.put(name, cars.get(name) + 1);
                }
            }

            System.out.println("실행 결과");
            for(String name:names){
                System.out.println(name+" : "+"-".repeat(cars.get(name)));
            }
            System.out.println();
        }
    }
}
