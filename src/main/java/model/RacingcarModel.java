package model;

import java.util.List;

public class RacingcarModel {
    private List<String> car_names;
    private int repeat;

    public RacingcarModel(List<String> car_names, String repeat){
        this.car_names = car_names;
        this.repeat = Integer.parseInt(repeat);
    }



}
