package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;


public class Control {
    public Control(String iterateNumber, ArrayList<String> nameList){
        try{
            int iterate = Integer.parseInt(iterateNumber);
            int[] carMove = new int[nameList.size()];
            for(int i=0;i<iterate;i++){
                carMoveCheck(carMove);
                carMovePrint(carMove, nameList);
            }
            winnerNamesPrint(carMove, nameList);
        }catch(NumberFormatException){
            throw new IllegalArgumentException("시도할 횟수의 입력이 잘못 되었습니다.");
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
    private void carMovePrint(int[] carMove, ArrayList<String> nameList){
        for(int i=0;i<carMove.length;i++){
            System.out.print(nameList.get(i)+" : ");
            for(int j=0;j<carMove[i];j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void winnerNamesPrint(int[] carMove, ArrayList<String> nameList){
        ArrayList<String> winnerNames = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int moveNumber : carMove){
            max = Math.max(max, moveNumber);
        }
        System.out.print("최종 우승자 : ");
        for(int i=0;i<nameList.size();i++){
            if (max == carMove[i]){
                winnerNames.add(nameList.get(i));
            }
        }
        if (winnerNames.size() == 1) {
            System.out.println(winnerNames.get(0));
        }else{
            System.out.println(String.join(", ", winnerNames));
        }
    }
}
