package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.regex.Pattern;

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
        return this.isLengthTwoMore() && this.isEnglishName();
    }

    public boolean isLengthTwoMore(){
        return this.carList.size() >= 2;
    }

    public boolean isEnglishName(){
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");

        for(String car: this.carList){
            if(!pattern.matcher(car).matches()) return false;
        }
        return true;
    }

    public List<String> getCarList(){
        return this.carList;
    }
}
