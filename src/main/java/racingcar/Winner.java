package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class Winner {

    private static String WinnerToString(Set<String> winner){
        String winners = "";
        int size = winner.size();
        int i = 0;
        for(String car : winner){
            winners += car;
            i+=1;
            if(i!=size){
                winners += ", ";
            }
        }
        return winners;
    }
    public void PrintWinner(Car[] cars){
        Set<String> winner = new HashSet<>();
//        String winnerNm = "";

        int maxPosition = 0;

        for(Car car: cars) {
            if (maxPosition == car.ReturnMove()) {
                winner.add(car.ReturnCarName());
                maxPosition += car.ReturnMove();
            } else if (maxPosition < car.ReturnMove()) {
                winner.clear();
                winner.add(car.ReturnCarName());
                maxPosition = car.ReturnMove();
            }
        }
        String winnerNm = WinnerToString(winner);
        System.out.println("최종 우승자 : " + winnerNm);
    }
}


