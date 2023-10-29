package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    public List<Car> names;

    public CarList(List<String> names) {
        // Car 생성자 만들어서 각각 집어넣기
    }

    // 랜덤으로 받을 수들 업데이트
    // car의 updateDistance 호출
    public void upgradeDistance(List<Integer> distances){

    }

    public List<String> getWinner(){
        List<String> winner = new ArrayList<>();
        return winner;
    }

    @Override
    /*
    * pobi : -
      woni :
      jun : -
      \n
    * 이렇게 공백까지 합쳐서 하나의 세트로 리턴하세요
    * */
    public String toString() {
        return "CarList{" +
                "names=" + names +
                '}';
    }
}
