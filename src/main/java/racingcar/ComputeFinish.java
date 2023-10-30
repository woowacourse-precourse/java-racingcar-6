package racingcar;

import java.util.List;

public class ComputeFinish {

    public void printFinish(List<String> name, List<Integer> result){
        StringBuilder winner = new StringBuilder("최종 우승자 : ");
        int maxDistance = 0;
        for(int i = 0; i < name.size(); i++){
            if(maxDistance < result.get(i)){
                maxDistance = result.get(i);
            }
        }
        for(int i = 0; i < name.size(); i++){
            if(maxDistance == result.get(i)){
                winner.append(name.get(i)).append(", ");
            }
        }

        winner = new StringBuilder(winner.substring(0, (winner.length() - 2)));
        System.out.println(winner);
    }
}
