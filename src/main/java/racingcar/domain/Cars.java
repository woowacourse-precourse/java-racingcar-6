package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    ArrayList<String> carNameList = new ArrayList<>();
    ArrayList<List<String>> carProgress = new ArrayList<>();


    public ArrayList<String> getCarNameList() {
        return carNameList;
    }

    public void setCarNameList(ArrayList<String> carNameList) {
        this.carNameList = carNameList;
    }

    public ArrayList<List<String>> getCarProgress() {
        return carProgress;
    }

    public void setCarProgress(ArrayList<List<String>> carProgress) {
        this.carProgress = carProgress;
    }


}
