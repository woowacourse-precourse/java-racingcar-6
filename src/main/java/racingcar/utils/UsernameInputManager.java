package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 사용자 이름 입력
 */
public class UsernameInputManager implements InputManager<List<String >>{
    private static final UsernameInputManager INSTANCE = new UsernameInputManager();
    private UsernameInputManager() {}
    public static UsernameInputManager getInstance() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return INSTANCE;
    }
    @Override
    public List<String> input() {
        try{
            String input = Console.readLine();
            String[] nameList = input.split(",");
            if(nameList.length==0)
                throw new RuntimeException();
            for (String name : nameList)
                if(name.isEmpty()||name.length()>5)
                    throw new RuntimeException();
            return List.of(nameList);
        }catch (RuntimeException e){
            throw new IllegalArgumentException();
        }
    }
}
