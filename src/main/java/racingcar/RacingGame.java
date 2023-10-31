package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
        public void game(List<Racingcar> cars, int roundNum){
                System.out.println("실행 결과");
                for (int i = 0; i < roundNum; i++){
                        for (int j = 0; j < cars.size(); j++){
                                carMove(cars.get(j));
                        }
                        currentStat(cars);
                }
        }

        private void carMove(Racingcar car){
                if (4 <= makeRandomNum()){
                        car.upMoveDistance();
                }
        }

        private int makeRandomNum(){
                return Randoms.pickNumberInRange(0, 9);
        }

        private void currentStat(List<Racingcar> cars){
                for (int i = 0; i < cars.size(); i++){
                        System.out.print(cars.get(i).getName());
                        System.out.print(" : ");
                        for (int j = 0; j < cars.get(i).getMoveDistance(); j++){
                                System.out.print("-");
                        }
                        System.out.println();
                }
                System.out.println();
        }
}
