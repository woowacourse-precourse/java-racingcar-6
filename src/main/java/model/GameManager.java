package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameManager {
    List<String> carName;
    int num;
    public GameManager(List<String> carName, int num) {
        this.carName = carName;
        this.num = num;
    }

    //게임 로직
    public void gameStart() {
        int[] carMoveCount = new int[carName.size()];

        StringBuffer sb = new StringBuffer();
        sb.append("실행 결과").append("\n");

        for(int i=0; i<num; i++) {

            for(int j=0; j<carName.size(); j++) {
                boolean flag = isMove();
                if(flag) carMoveCount[j]++;

                sb.append(carName.get(j)).append(" : ").append("-".repeat(carMoveCount[j])).append("\n");
            }

            sb.append("\n");
        }

        List<Integer> winner = whoWin(carMoveCount);

        sb.append("최종 우승자 : ").append(carName.get(winner.get(0)));

        for(int i=1; i<winner.size(); i++) {
            sb.append(", ").append(carName.get(winner.get(0)));
        }

        System.out.println(sb);
    }

    public boolean isMove() {
        int randomNum = Randoms.pickNumberInRange(0,9);

        return randomNum >= 4;
    }

    public List<Integer> whoWin(int[] carMoveCount) {
        int[] copyArr = carMoveCount.clone();
        Arrays.sort(copyArr);

        int max = copyArr[copyArr.length-1];

        List<Integer> winner = new ArrayList<>();
        for(int i=0; i< carMoveCount.length; i++) {
            if(carMoveCount[i] == max) {
                winner.add(i);
            }
        }

        return winner;
    }

}
