package util;

import java.util.ArrayList;

public class CarList<Car> extends ArrayList<Car> {

    public CarList(ArrayList<Car> list){
        super(list);
    }
    @Override
    public boolean contains(Object o){

        if(o==null) return false;

        for(Car car:this){
            if(car.equals(o)) return true;
        }
        return false;
    }
}
