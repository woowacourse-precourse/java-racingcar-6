package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.entity.User;

public class UserService {

    public List<User> makeUser(){

        String users = Console.readLine();

        String[] userArr = users.split(",");

        List<User> userList = userList(userArr);

        return userList;
    }

    public void checkUser(User user){
        if(user.getName().length() > 5){
            throw new IllegalArgumentException("입력 문자열의 길이는 5 이하여야 합니다.");
        }
    }

    public List<User> userList(String[] userArr){
        List<User> userList = new ArrayList<>();

        for (String userName : userArr) {
            User user = new User();
            user.setName(userName);
            checkUser(user);
            userList.add(user);
        }

        return userList;
    }
}