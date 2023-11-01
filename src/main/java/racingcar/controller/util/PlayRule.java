package racingcar.controller.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Cars;

import java.util.List;

import static racingcar.constant.Limits.*;

public class PlayRule {
    public void playDices(List<Cars> carsList) {
//        전체 차량 1회 다이스
        for (Cars car : carsList) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_SIZE, MAX_RANDOM_SIZE);
            if (randomNumber >= MIN_RUNNING_SIZE) {
                car.upLoadState();
            }
        }
        System.out.println();
    }

    public String getResult(List<Cars> carsList) {
//        승자 가려내기
        String winner = "";
        int bestRecord = 0;
        int thisRecord;

        for (Cars car : carsList) {
            thisRecord = car.getLength();
//            기존 기록과 공동일 경우
            if (thisRecord == bestRecord) {
                winner = winner.concat(", " + car.getName());
            }
//            기존 기록을 능가하는 경우
            if (thisRecord > bestRecord) {
                bestRecord = thisRecord;
                winner = car.getName();
            }
        }
        return winner;
    }

    public int getRound(String s){
        return Integer.parseInt(s);
    }

    public List<Cars> addCar(String name, List<Cars> list){
        Cars newCar = new Cars(name, "");
        list.add(newCar);
        return list;
    }
}
