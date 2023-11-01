package racingcar;

import java.util.List;

public class PrintProgress {

    public void printResult(List<String> name, List<Integer> result){
        for (int i = 0 ; i < name.size(); i++) {
            System.out.print(name.get(i) + " : ");
            for (int j = 0 ; j < result.get(i); j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
