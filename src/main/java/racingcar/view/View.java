package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.GameController;
import racingcar.controller.UserController;
import racingcar.entity.User;

public class View {
    private final UserController userController = new UserController();
    private final GameController gameController = new GameController();

    public void main(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<User> users = userController.makeUser();
        System.out.println("시도할 회수는 몇회인가요?");
        int count = gameController.gameCount();
        System.out.println("실행 결과");
        gameInitView(count, users);
        winnerView(gameController.winner(users));
    }

    public void gameInitView(int count, List<User> users){
        for(int i=0;i<count;i++){
            gameController.game(users);
            gamePlayView(users);
        }
    }

    public void gamePlayView(List<User> users){
        users.forEach(user ->{
            System.out.print(user.getName()+" : ");
            String dashes = "-".repeat(user.getScore());
            System.out.println(dashes);
        });
        System.out.println();
    }

    public void winnerView(List<User> winners){
        System.out.print("최종 우승자 : ");
        String result = winners.stream()
                .map(User::getName)
                .collect(Collectors.joining(", "));
        System.out.print(result);
    }

}
