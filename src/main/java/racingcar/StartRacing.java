package racingcar;

import camp.nextstep.edu.missionutils.Console;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;

import java.util.ArrayList;
import java.util.List;

public class StartRacing {
    private static final String GAME_START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACING_NUMBER = "시도할 회수는 몇회인가요?";
    private static final String GAME_RESULT = "최종 결과";
    private static final String WINNER_NAME = "최종 우승자 : ";
    private CarRacing carRacing;

    public void startRacing(){
        System.out.println(GAME_START);
        String carName = Console.readLine();
        ArrayList<String> carNameList = checkName(carName);

        System.out.println(RACING_NUMBER);
        String racingNumberString = Console.readLine();
        int racingNumberInt = isNum(racingNumberString);

        System.out.println();
        System.out.println(GAME_RESULT);
        String winner = carRacing.carRacing(carNameList, racingNumberInt);

        System.out.println(WINNER_NAME + winner);


    }


    public int isNum(String input){
        try{
            int num = Integer.parseInt(input);
            return num;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    public ArrayList<String> checkName(String input){
        ArrayList<String> nameList = new ArrayList<>(List.of(input.split(",")));
        for(int i=0;i<nameList.size();i++){
            if(nameList.get(i).length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return nameList;
    }


}
