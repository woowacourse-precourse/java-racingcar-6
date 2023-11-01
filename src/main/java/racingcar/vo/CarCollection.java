package racingcar.vo;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarCollection {
    private final List<CarInfo> carInfoList;

    public CarCollection(List<CarInfo> carInfoList) {
        this.carInfoList = carInfoList;
    }

    public List<CarInfo> getCarList(){
        return Collections.unmodifiableList(carInfoList);
    }

    public Map<Integer, List<CarInfo>> groupByMoveCnt(){
        return carInfoList.stream()
            .collect(Collectors.groupingBy(CarInfo::getMoveCnt,
                LinkedHashMap::new, Collectors.toList()));
    }

    public String getCarName(){
        final StringBuilder carCollectionToString = new StringBuilder();
        carInfoList.forEach(carInfo -> {
            carCollectionToString.append(carInfo.getName());
            if(carInfoList.indexOf(carInfo) != carInfoList.size()-1)
                carCollectionToString.append(", ");
        });
        return carCollectionToString.toString();
    }
}
