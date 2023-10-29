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
