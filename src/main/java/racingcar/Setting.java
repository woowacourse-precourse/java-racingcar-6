package racingcar;

import exception.ExceededStringException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static camp.nextstep.edu.missionutils.Console.*;

public class Setting {
    List<Car> cars = new ArrayList<>();
    private int cycleNumber;

    public Setting(){}

    public List<Car> settingStart(){
        try{
            List<Car> cars = beforeSetting();
        }
        catch (IllegalStateException ex){
            System.out.println(ex.getMessage());
        }
        return cars;
    }

    private List<Car> beforeSetting(){

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = readLine();
        List<Car> cars = settingName(names);

        System.out.println("시도할 회수는 몇회인가요?");
        cycleNumber = Integer.parseInt(readLine());
        return cars;
    }

    public List<Car> settingName(String names) {
        StringTokenizer st = new StringTokenizer(names, ",");
        while(st.hasMoreTokens()){
            String name = st.nextToken();
            validateName(name);
            cars.add(new Car(name));
        }
        return cars;
    }

    private void validateName(String name) {
        if(name.length()>5) {
            throw new ExceededStringException();
        }
    }

    public List<Car> getCars(){
        return cars;
    }
    public int getCycleNumber(){
        return cycleNumber;
    }

}
