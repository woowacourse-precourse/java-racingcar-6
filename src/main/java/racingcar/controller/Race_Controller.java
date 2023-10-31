package racingcar.controller;

import racingcar.model.Car_Name;
import racingcar.util.Validator;
import racingcar.util.Count;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;
import java.util.ArrayList;

public class Race_Controller {
    private Car_Name car_name;
    private Validator validator;
    private Count count;

    public Race_Controller() {
        this.car_name = new Car_Name(Input.startRace());
        this.count = new Count(Input.count_Set());
        // this.validator = new Validator();
    }

    public void start() {
        Output.show_Mid_Result();
        for (int i = 0; i < count.get_Count(); i++) {
            increase_Count();
            Output.show_Mid_Name(car_name.get_Car_Map());
        }
        Output.show_Final_Result();
        Output.show_Winners(find_Winner());
    }

    public void increase_Count() {
        for (String key : car_name.get_Car_NameSet()) {
            this.validator = new Validator();
            if (check()) {
                car_name.get_Car_Map().put(key, car_name.get_Car_Count(key) + 1);
            }
        }
    }

    public boolean check() {
        return validator.is_forward();
    }

    public List<String> find_Winner() {
        List<String> list = new ArrayList<>();
        int max = 0;
        for (String key : car_name.get_Car_NameSet()) {
            if (max == car_name.get_Car_Count(key)) {
                list.add(key);
                continue;
            }
            if (max < car_name.get_Car_Count(key)) {
                list.clear();
                max = car_name.get_Car_Count(key);
                list.add(key);
            }
        }
        return list;
    }
}
