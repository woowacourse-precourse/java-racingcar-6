package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {

    public static void forward(List<Car> cars){
        for(Car c: cars) {
            if (pickNumberInRange(0, 9) >= 4) {
                c.distance += 1;
            }
        }
    }

    public static void sortCarDistance(List<Car> carList){
        carList.sort((c1, c2) -> c2.distance - c1.distance);
    }

    public static List<String> winnerListGenerator(List<Car> carList){
        List<String> winners = new ArrayList<>();

        for(Car c: carList){
            if(c.distance == carList.get(0).distance){
                winners.add(c.name);
            }
        }

        return winners;
    }

    public static void main(String[] args) {

        Print.message(1);

        String[] carName = Get.carName();

        try {
            for(String s: carName){
                if(s.length() > 5){
                    throw new IllegalArgumentException();
                }
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }

        Print.message(2);

        int playCount = Get.playCount();

        List<Car> carList = new ArrayList<>();

        for(String s: carName){
            Car c = new Car(s);
            carList.add(c);
        }

        Print.message(3);

        for(int i = 0;i<playCount;i++){
            forward(carList);
            Print.result(carList);
            System.out.println();
        }

        sortCarDistance(carList);

        List<String> winners = winnerListGenerator(carList);

        Print.winner(winners);

    }
}
