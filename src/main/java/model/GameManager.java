package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameManager {
    List<String> carName;
    int num;
    public GameManager(List<String> carName, int num) {
        this.carName = carName;
        this.num = num;
    }

    //게임 로직
    public boolean gameStart() {
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

        System.out.println(sb);

        return true;
    }

    public boolean isMove() {
        int randomNum = Randoms.pickNumberInRange(0,9);

        if(randomNum >= 4) return true;
        return false;
    }

}
