package racingcar.View;

import racingcar.Model.CarHashMap;

import java.util.Iterator;
import java.util.Set;

public class PrintView {

    public void firstSentenceView(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void secondSentenceView(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void gameResultView(Set<String> names){
        System.out.print("최종 우승자 : ");
        String temp = "";
        Iterator<String> it = names.iterator();
        temp += it.next();
        while(it.hasNext())
            temp += ", " + it.next();

        System.out.print(temp);
    }

    public void gameStartView(CarHashMap cars, int times){
        Iterator<String> it = cars.getIterator();

        while(it.hasNext()){
            String name = it.next();
            System.out.print(name + " : ");
            for(int i = 0; i < cars.getValue(name); i++){
                System.out.print("-");
            }
            System.out.println("");
        }

    }
}
