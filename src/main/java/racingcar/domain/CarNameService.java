package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarNameService {
    private final static String partition = ",";
    private final static String exceptionMessageOfNull = "이름이 입력되지 않았습니다.";
    private final static String exceptionMessageOfBlank = "공백을 포함할 수 없습니다.";
    private final static String exceptionMessageOfLength = "이름의 길이는 5자 이하만 가능합니다.";

    private ArrayList<Car> carList;


    public void input(){
        InputName inputName = new InputName();
        String input = inputName.getInput();

        List<String> nameList = convertStrToList(input);
        makeCarList(nameList);
    }

    public List<String> convertStrToList(String str){
        List<String> nameList = new ArrayList<>();

        String[] splited = str.split(partition);
        for(String s: splited){
            if(checkException(s)) nameList.add(s);
        }

        return nameList;
    }

    public boolean checkException(String s){
        if(s==null) throw new IllegalArgumentException(exceptionMessageOfNull);
        if(s.contains(" ")) throw new IllegalArgumentException(exceptionMessageOfBlank);
        if(s.length()>5) throw new IllegalArgumentException(exceptionMessageOfLength);

        return true;
    }

    public void makeCarList(List<String> nameList){
        ArrayList<Car> carList = new ArrayList<>();
        for(String carName: nameList){
            carList.add(new Car(carName));
        }
        this.carList = carList;
    }

    public ArrayList<Car> getCarList(){
        return this.carList;
    }

}
