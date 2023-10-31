package racingcar.Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CarHashMap {
    private HashMap<String, Integer> cars = null;

    public CarHashMap(String[] names){
        cars = new HashMap<>();
        for(String name : names){
            cars.put(name, 0);
        }
    }

    public HashMap<String, Integer> getCars(){
        return cars;
    }

    public int getCarNumbers(){
        return cars.size();
    }

    public Set<String> getKeys(){
        return cars.keySet();
    }

    public Collection<Integer> getValues(){
        return cars.values();
    }
    public int getValue(String key){return cars.get(key);}
    public Iterator<String> getIterator(){return cars.keySet().iterator();}

    public void increaseValue(String key){
        cars.put(key, cars.get(key) + 1);
    }
}
