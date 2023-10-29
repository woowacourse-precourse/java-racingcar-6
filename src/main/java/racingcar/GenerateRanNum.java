package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class GenerateRanNum {
    //난수 생성
    public int ranNum(){
        return Randoms.pickNumberInRange(0,9);
    }

    public HashMap<String,Integer> carHashMap(String[] carList){
        HashMap<String,Integer> carMap = new HashMap<>();

        for(String car : carList){
            int ranNum = ranNum();
            carMap.put(car,ranNum);
        }
        return carMap;
    }

    public List<HashMap<String, Integer>> carMapList(HashMap<String,Integer> carMap){
        List<HashMap<String, Integer>> carMapList = new ArrayList<>();
        carMapList.add(carMap);
        return carMapList;
    }


}
