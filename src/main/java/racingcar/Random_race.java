package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import static racingcar.Input_car.car_map;
import static racingcar.Input_car.excute_count;

public class Random_race {
    public static void ramdom_race() {
        System.out.println("실행 결과");
        while(excute_count != 0){
            for(String k : car_map.keySet()){
                int randomNum = Randoms.pickNumberInRange(0,9);
                if(4<=randomNum){
                    car_map.put(k, car_map.getOrDefault(k, 0) +1);
                }

            }
            for(String k : car_map.keySet()){
                System.out.println(k + " : " + "-".repeat(car_map.get(k)));
            }
            System.out.println();
            excute_count--;
        }

    }

}
