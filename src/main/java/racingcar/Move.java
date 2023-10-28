package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Move {
    public int getMove(){
        System.out.println("시도할 회수는 몇회인가요?");
        int move = Integer.parseInt(Console.readLine());
        return move;
    }

    public void printProgress(List<String> carNameList, int move){

        int[] position = new int[carNameList.size()];
        System.out.println(position[0] + " " + position[1] + " " + position[2]);
        for(int i = 0; i < move; i++){
            for (int j = 0; j  < carNameList.size(); j++) {
                System.out.print(carNameList.get(j) + " : ");
                if(stopAndGo()) {
                    position[j]++;
                }
                for(int k = 0; k < position[j]; k++){
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.print("최종 우승자 : ");
        int[] num = new int[position.length];
        for(int i = 0; i < position.length; i++){
            if(position[i] == Arrays.stream(position).max().getAsInt()){
                if(i != 0){
                    System.out.print(",");
                }
                System.out.print(carNameList.get(i));
                num[i] = 1;
            }
        }
    }

    private boolean stopAndGo() {
        int random = Randoms.pickNumberInRange(1, 9);
        if (random > 3) {
            return true;
        }
        return false;
    }
}
