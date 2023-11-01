package racingcar;

import java.math.BigInteger;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
        public void game(List<Racingcar> cars, BigInteger roundNum){
                System.out.println("실행 결과");
                while (roundNum.compareTo(BigInteger.ZERO) != 0){
                        for (int j = 0; j < cars.size(); j++){
                                carMove(cars.get(j));
                        }
                        currentStat(cars);
                        roundNum = roundNum.subtract(BigInteger.ONE);
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
                BigInteger distance;
                for (int i = 0; i < cars.size(); i++){
                        System.out.print(cars.get(i).getName());
                        System.out.print(" : ");
                        distance = cars.get(i).getMoveDistance();
                        while (distance.compareTo(BigInteger.ZERO) != 0){
                                System.out.print("-");
                                distance = distance.subtract(BigInteger.ONE);
                        }
                        System.out.println();
                }
                System.out.println();
        }
}
