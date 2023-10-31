package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class GenerateRanNum {
    List<HashMap<String, Integer>> carHashMapList= new ArrayList<>();

    public int ranNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public HashMap<String, Integer> carHashMap(String[] carNames) {
        HashMap<String, Integer> carMap = new HashMap<>();

        for (String car : carNames) {
            int ranNum = ranNum();
            carMap.put(car, ranNum);
        }
        return carMap;
    }

    public void returnCarMapList(String[] carList,int count){
        GenerateRanNum generateRanNum = new GenerateRanNum();

        int i = 0;
        while(i<count){
            HashMap<String,Integer> carMap = generateRanNum.carHashMap(carList);
            carHashMapList.add(carMap);
            i+=1;
        }
    }


    //난수 생성
}


