package racingcar;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static camp.nextstep.edu.missionutils.Console.*;

public class Setting {
    List<Car> cars = new ArrayList<>();
    int cycleNumber;

    public Setting(){
        try{
           beforeSetting();
        }catch (IllegalStateException ex){
            System.out.println("잘못받았습니다");

        }
    }

    private void beforeSetting(){

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        settingName();

        System.out.println("시도할 회수는 몇회인가요?");
        cycleNumber = Integer.parseInt(readLine());
    }

    private void settingName() {
        String names = readLine();
        StringTokenizer st = new StringTokenizer(names, ",");
        while(st.hasMoreTokens()){
            String name = st.nextToken();
            validateName(name);
            cars.add(new Car(name));
        }
    }

    private void validateName(String name) {
        if(name.length()>5) {
            throw new IllegalStateException();
        }
    }

    public List<Car> getCars(){
        return cars;
    }
    public int getNumber(){
        return cycleNumber;
    }

}
