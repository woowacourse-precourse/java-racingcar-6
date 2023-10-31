package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputManager {
    public List<Car> makeCars () {
        
        List<Car> cars = new ArrayList<>();

        String input = Console.readLine();
        String[] temps = input.split(",", -1); // 정규 표현식을 사용하여 문자 분리
        
        for (String temp : temps) {
            Car carTemp = new Car(temp);
            cars.add(carTemp);
        }
        
        return cars;
        
    }
    
    public int howMany() {
        
        int num;
        
        try {
            num = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input", e);
        }
        
        return num;
    }
    
}
