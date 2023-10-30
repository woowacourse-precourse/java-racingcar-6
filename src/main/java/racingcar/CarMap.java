package racingcar;

import java.util.*;

public class CarMap {

    private final LinkedHashMap<String, String> carMap = new LinkedHashMap<>();

    public CarMap(String carList){

        boolean isValidated = validateCarList(carList);

        if(isValidated) {
            StringTokenizer st = new StringTokenizer(carList, ",");
            StringBuilder sb = new StringBuilder();
            while(st.hasMoreTokens()){
                carMap.put(st.nextToken(), "");
            }
        }

    }

    public boolean validateCarList(String carList){
        if(carList == null) throw new IllegalArgumentException();
        if(carList.isEmpty()) throw new IllegalArgumentException();

        StringTokenizer st = new StringTokenizer(carList, ",");
        while(st.hasMoreTokens()){
            if(st.nextToken().length() > 5) throw new IllegalArgumentException();
        }
        return true;
    }

    public LinkedHashMap<String, String> getMap(){
        return carMap;
    }

    public Set<String> getKeySet(){ return carMap.keySet(); }

    public void go(String key){
        String value = carMap.get(key);
        value += "-";
        carMap.replace(key, value);
    }
}
