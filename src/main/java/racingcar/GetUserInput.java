package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;

public class GetUserInput {
    public GetUserInput(){
    }

    public ArrayList<String> getName(){
        String userInput;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        userInput = Console.readLine();
        ArrayList<String> carList = new ArrayList<>(Arrays.asList(userInput.split(",")));
        for(int i = 0; i < carList.size(); i++){
            if(carList.get(i).length() >= 5){
                exception();
            }
        }
        return carList;
    }

    public int getTryNumber(){
        int userInput = 0;

        System.out.println("시도할 회수는 몇회인가요?");
        userInput = Integer.parseInt(Console.readLine());

        return userInput;
    }

    public void exception(){
        throw new IllegalArgumentException();
    }
}
