package racingcar.model;

import java.util.LinkedHashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Car_Name {
    private Map<String, Integer> car;
    String delimiter = ",";

    public Car_Name(String name) {
        car = new LinkedHashMap<>();
        WordCheck(name);
        LengthCheck(name);
        DuplicateCheck(name);
        String[] arr = name.split(delimiter);
        for (int i = 0; i < arr.length; i++) {
            car.put(arr[i], 0);
        }
    }

    public Map<String, Integer> get_Car_Map() {
        return car;
    }

    public void show() {
        for (String key : car.keySet()) {
            System.out.println(key + " " + car.get(key));
        }
    }

    public Set<String> get_Car_NameSet() {
        return car.keySet();
    }

    public int get_Car_Count(String key) {
        return car.get(key);
    }
    // public void Delimter_Check()throws IllegalArgumentException{

    // }
    public void WordCheck(String name) throws IllegalArgumentException {
        name = name.toLowerCase();
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (!((ch >= 'a' && ch <= 'z') || ch == ',')) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(허용되지 않은 문자 입력)");
            }
        }
    }

    public void LengthCheck(String name) throws IllegalArgumentException {
        String[] arr = name.split(delimiter);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > 5) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(이름 5글자 초과)");
            }
        }
    }

    public void DuplicateCheck(String name) throws IllegalArgumentException {
        Set<String> set = new HashSet<>();
        String[] arr = name.split(delimiter);
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        if (set.size() != arr.length) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.(중복된 사용자 입력)");
        }
    }
}
