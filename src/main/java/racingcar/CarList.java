package racingcar;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class CarList {
    private List<String> carList;

    CarList(){
        this.carList = new ArrayList<>();
    }

    public void setCarName(){
        String carString = Console.readLine();
        String[] carArray = carString.split(",");
        this.carList = Arrays.asList(carArray);
    }

    public boolean checkCarName(){
        return this.hasAtLeastTwoItems() && this.isShortEnglishName() && this.isDuplicate();
    }

    private boolean hasAtLeastTwoItems(){
        return this.carList.size() >= 2;
    }

    private boolean isDuplicate(){
        Set<String> carSet = new HashSet<>(carList);

        return carSet.size() == carList.size();
    }

    private boolean isShortEnglishName(){
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");

        for(String car: this.carList){
            if(!((car.length() < 6) && pattern.matcher(car).matches())) return false;
        }
        return true;
    }

    public List<String> getCarList(){
        return this.carList;
    }
}
