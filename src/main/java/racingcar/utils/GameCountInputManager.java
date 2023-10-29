package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

/**
 * 게임 횟수 입력
 */
public class GameCountInputManager implements InputManager<Integer>{
    private static final GameCountInputManager INSTANCE=new GameCountInputManager();
    private GameCountInputManager(){}
    public static GameCountInputManager getInstance() {
        System.out.println("시도할 회수는 몇회인가요?");
        return INSTANCE;
    }
    @Override
    public Integer input() {
        try{
            String input = Console.readLine();
            if(Integer.parseInt(input)<0)
                throw new IllegalArgumentException();
            return Integer.parseInt(input);
        }catch (RuntimeException e){
            throw new IllegalArgumentException();
        }
    }
}