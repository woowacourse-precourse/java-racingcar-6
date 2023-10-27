package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;

public class CarName {
    private String carNames;
    private ArrayList<String> carList= new ArrayList<>();
    private ArrayList<String> clearCarList= new ArrayList<>();
    public void InputCarNames(){
        carNames = Console.readLine();
    }

    public void CarNamesToList(){
        StringTokenizer cars = new StringTokenizer(carNames,",");
        while(cars.hasMoreTokens()){
            this.carList.add(cars.nextToken());
        }
    }
    public void clearCarList(ArrayList<String> carList){
        isSameCarName(carList);
        isCarNameLengthOver5(carList);
        isSeperatorNotComma(carList);
        this.clearCarList = carList;
    }
    public ArrayList<String> getClearCarList(){
        return clearCarList;
    }

    public void isSameCarName(ArrayList<String> carList) throws IllegalArgumentException{
        HashSet<String> set = new HashSet<>(carList);
        if(set.size() != carList.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 없어야 합니다.");
        }
    }
    public void isCarNameLengthOver5(ArrayList<String> carList) throws IllegalArgumentException{
        if(carList.size() > 5){
            throw new IllegalArgumentException("자동차 이름의 길이는 5 이하여야 합니다.");
        }
    }
    public void isSeperatorNotComma(ArrayList<String> carList) throws IllegalArgumentException{
        int cnt = 0;
        for(Character c: carNames.toCharArray()){
            if(c == ','){
                cnt++;
            }
            if(cnt != carList.size()-1){
                throw new IllegalArgumentException("구분자는 자동차 이름 사이의 쉼표입니다.");
            }
        }
    }
}
