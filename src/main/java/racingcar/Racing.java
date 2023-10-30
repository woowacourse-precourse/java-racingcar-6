package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Racing {
    public void racing(){
        User user = new User();
        Car car = new Car();

        Map<String,Integer> names = car.namesOfCars();
        int num = user.numberOfMoves();
        System.out.println("실행 결과");
            for(int i=0;i<num;i++){
                for(Map.Entry<String,Integer> entry : names.entrySet()){
                    int randomNum = Randoms.pickNumberInRange(0,9);
                    System.out.println(randomNum);
                    String key =entry.getKey();
                    int value = entry.getValue();
                    if(randomNum >= 4){
                        names.put(key, value+1);
                    }
                    System.out.print(key+" : ");
                    for(int j = 0; j<entry.getValue();j++){
                        System.out.print("-");
                    }
                    System.out.println();

                    }
                System.out.println();
                }
        System.out.print("최종 우승자 : ");
        List<String> winners= new ArrayList<>();
        for(Map.Entry<String,Integer> entry: names.entrySet()){
            if (entry.getValue() == num) {
                winners.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", winners));
            }


    }

