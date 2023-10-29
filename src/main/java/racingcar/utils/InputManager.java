package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 입력 처리
 */
public enum InputManager {
    INPUT_NAME {//사용자 이름 입력
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
    },
    INPUT_MOVE_COUNT{// 시행 횟수 입력
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
    };

    public abstract Object input();
}
