package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;


public class Control {
    public Control(String iterateNumber, ArrayList<String> nameList){
        int iterate = Integer.parseInt(iterateNumber);
        int[] carMove = new int[nameList.size()];
        for(int i=0;i<iterate;i++){
            carMoveCheck(carMove);
        }
    }

    private void carMoveCheck(int[] carMove){
        for(int i=0;i<carMove.length;i++){
            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= 4){
                carMove[i]++;
            }
        }
    }


}
