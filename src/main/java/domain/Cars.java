package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    //쉼표로 나눠진 차들을 기반으로 각각의 차의 위치 리스트 생성

    List<String> carPos;

    public void setCars(List<String> cars) {
        carPos = new ArrayList<String>();
        for (int i = 0; i < cars.size(); i++) {
            carPos.add("");
        }
    }

    public void move(List<String> cars) {
        for (int i = 0; i < cars.size(); i++) {
            if (randomNum()) {
                carPos.set(i, carPos.get(i) + "-");
            }
        }
        printCars(cars);
    }

    public boolean randomNum() {
        int num = Randoms.pickNumberInRange(0, 9);
        if (num >= 4) {
            return true;
        }
        return false;
    }
    public void printCars(List<String>cars){
        for (int i=0;i<carPos.size();i++){
            System.out.println(cars.get(i)+" : "+carPos.get(i));
        }
        System.out.println();
    }
    public void printWinner(List<String>cars){
        int count=0;
        for (int i=0;i<cars.size();i++){
            if (count<carPos.get(i).length()){
                count=carPos.get(i).length();
            }
        }
        List<String> winner = new ArrayList<>();
        for (int i=0;i<cars.size();i++){
            if (count==carPos.get(i).length()){
                winner.add(cars.get(i));
            }
        }
        String result = String.join(",",winner);
        System.out.println("최종 우승자 : "+result);
    }
}
