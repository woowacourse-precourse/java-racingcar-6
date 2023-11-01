package model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static int tryCount;

    /** 사용자 시도 횟수 저장 */
    public static void setTryCount(int tryCount) {
        Game.tryCount = tryCount;
    }

    /** 사용자 시도 횟수 얻기 */
    public static int getTryCount() {
        return tryCount;
    }

    /**
     * 자동차 실행 결과 가공하기
     *
     * @param carList 경주한 자동차와 이동횟수를 담은 List
     * @return "자동차명 : 전진횟수" 형태로 가공하여 리턴
     */
    public List<String> getRacingGameResultList(List<Car> carList){
        List<String> racingGameResultList = new ArrayList<>();

        for(Car car : carList){
            String step = "";
            int stepCount = car.getStepCount();
            while (stepCount > 0){
                stepCount--;
                step += "-";
            }

            StringBuilder gameText = new StringBuilder(car.getName())
                    .append(" : ")
                    .append(step);
            racingGameResultList.add(gameText.toString());
        }

        return racingGameResultList;
    }

//    우승자 판단하기()
//    우승자 결과 데이터 가공하기()

}

