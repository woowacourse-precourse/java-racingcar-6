package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import racingcar.Model.CarModel;

public class ResultComposer {
    public static String resultComposer(List<CarModel> carModelList){
        int max = 0;
        List<String> names = new ArrayList<>();
        for(int i=0; i<carModelList.size(); i++){
            CarModel carmodel = carModelList.get(i);
            if(max < carmodel.getRaceCnt()){
                max = carmodel.getRaceCnt();
                names.clear();
                names.add(carmodel.getCarName());
            }
            else if(max == carmodel.getRaceCnt()){
                names.add(carmodel.getCarName());
            }
        }
        return makeResult(names);
    }

    public static String makeResult(List<String> names){
        String result="";
        for(int i=0; i<names.size(); i++){
            if(i==0) {
                result += names.get(i);
                continue;
            }
            result+= ", " + names.get(i);
        }
        return result;
    }
}
