package racingcar.PlayGame;

import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import racingcar.View.error.Error;
import racingcar.View.error.InputException;
import racingcar.player.User;

public class FindWinner {

    public List<String> findWinner(List<User> user) {

        return user.stream()
                .collect(Collectors.groupingBy(User::getForwardDistance))//거리값 에 유저를 그룹화,MAP<user,value>
                .entrySet().stream()//엔트리셋을 스트림으로 변환,각 엔트리가 스트림 요소
                .max(Comparator.comparingInt(Entry::getKey))//각 그룹의 키 에서 최대값을 찾음
                .map(Entry::getValue)//키가 최댓값을 가지는 그룹의 유저 목록
                .orElseThrow(() -> new InputException(Error.USERNAME_UNDEFINED_ERROR))//유저 목록이 비어 있으면 예외처리
                .stream()//유저 목록 스트림 변횐
                .map(User::getUserName)//유저목록 에서 이름을 스트림 요소로 만듬
                .collect(Collectors.toList());//스트림에 존재하는 이름들을 리스트로 수집
    }

}
