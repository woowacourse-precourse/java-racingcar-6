package racingcar;

import java.util.ArrayList;
import java.util.List;

public class InputManager {
    
    
    public List<Car> makeCars (String input) {
        List<Car> cars = new ArrayList<>();
        String[] temps = input.split(",", -1); // 정규 표현식을 사용하여 문자 분리
        List<String> names = new ArrayList<>(); // 이름 중복되는지 확인
        for (String temp : temps) {
            verifyDuplicatedName(names, temp);
            Car carTemp = new Car(temp);
            cars.add(carTemp);
        }
        return cars;
    }
    
    private void verifyDuplicatedName(List<String> names, String temp) {
        if(names.contains(temp)){
            throw new IllegalArgumentException("Invalid name: Duplicated car names");
        } else {
            names.add(temp);
        }
    }
    
    public int howMany(String numStr) {
        int num;
        
        try {
            num = Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input", e);
        }

        return num;
    }
    
}
