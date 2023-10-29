package racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CarMap {

    private Map<String, String> carMap = new HashMap<>();

    public CarMap(String carList){

        boolean isValidated = validateCarList(carList);

        if(isValidated) {
            StringTokenizer st = new StringTokenizer(carList, ",");
            while(st.hasMoreTokens()){
                carMap.put(st.nextToken(),null);
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

    public Map<String, String> getKey(){
        return carMap;
    }

    public void setValue(String key, String value){
        carMap.replace(key, value);
    }
}
