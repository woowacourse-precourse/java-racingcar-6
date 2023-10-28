package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.lang.Integer.parseInt;


public class Racing {
    List<String> carNames;
    List<String> carPoints;
    private Racing(){

    }
    public List<String> getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
        carNames = Arrays.asList(Console.readLine().split(","));
        checkNameLength(carNames);

        return carNames;
    }
    private int checkNameLength(List<String> carNames){
        for(int i=0;i<carNames.size();i++){
            if(carNames.get(i).length()>5) {
                throw new IllegalArgumentException("each racing car's name must be shorter than 6");
            }
        }
        return carNames.size();
    }
    public int getRoundCount(){
        System.out.println("시도할 회수를 입력하세요");
        try{return parseInt(Console.readLine());}
        catch(IllegalArgumentException e){
            e.printStackTrace(); //예외정보 출력 (호출스택(Call Stack)에 있었던 메서드의 정보와 예외 메세지를 콘솔화면에 출력)
            throw e;
        }

    }
    public int playRound(){

    }
   private List<Integer> getRanNUM(){
        List<Integer> ranNumList;
        ranNumList= new ArrayList<Integer>();
        for(int i=0; i<carNames.size(); i++){
            ranNumList.add(Randoms.pickNumberInRange(0,9));
        }
        return ranNumList;
    }

}
