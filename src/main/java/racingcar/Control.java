package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;


public class Control {
    private int iterate;
    private static int[] carMove;

    public Control(String iterateNumber, ArrayList<String> nameList){
        this.iterate = convertToInt(iterateNumber);
        carMove = new int[nameList.size()];
    }

    private int convertToInt(String iterateNumber) {
        try {
            return Integer.parseInt(iterateNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수의 입력이 잘못 되었습니다.", e);
        }
    }

    public void executeRacing(ArrayList<String> nameList) {
        for (int i=0;i<iterate;i++) {
            carMoveCheck();
            carMovePrint(nameList);
        }
        winnerNamesPrint(nameList);
    }

    private void carMoveCheck(){
        for(int i=0;i<carMove.length;i++){
            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= 4){
                carMove[i]++;
            }
        }
    }
    private void carMovePrint(ArrayList<String> nameList){
        for(int i=0;i<carMove.length;i++){
            System.out.print(nameList.get(i)+" : ");
            for(int j=0;j<carMove[i];j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void winnerNamesPrint(ArrayList<String> nameList){
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
