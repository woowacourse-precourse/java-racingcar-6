package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Go {
    RandomNum randomnum = new RandomNum();
    public void Race(List<String> carname, List<Integer> carposition) {
        for(int i = 0; i < carname.size(); i++) {
            int num = carposition.get(i);
            String position = "";
            int random = randomnum.Number();
            if (random == 1) {
                carposition.add(i, num+1);
            }

            System.out.print(carname.get(i));
            System.out.print(": ");
            for (int j = 0; j < carposition.get(i); j++) {
                System.out.print("_");
            }
            System.out.println("");
        }
    }
    public List<String> Result(List<String> carname, List<Integer> carposition) {
        int max = 0;
        List<String> result = new ArrayList<>();
        for(int i = 0; i < carposition.size(); i++) {
            if (max < carposition.get(i)) {
                max = carposition.get(i);
            }
        }
        for(int i = 0; i < carposition.size(); i++) {
            if (carposition.get(i) == max) {
                result.add(carname.get(i));
            }
        }
        return result;
    }

}
