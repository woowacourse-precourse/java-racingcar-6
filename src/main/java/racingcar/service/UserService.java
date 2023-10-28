package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.entity.User;

public class UserService {

    public void makeUser(){

        String users = Console.readLine();

        String[] userArr = users.split(",");

        List<User> userList = userList(userArr);
    }

    public List<User> userList(String[] userArr){
        List<User> userList = new ArrayList<>();

        for (String userName : userArr) {
            User user = new User();
            user.setName(userName);
            userList.add(user);
        }

        return userList;
    }
}