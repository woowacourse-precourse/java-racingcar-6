package racingcar;

public class Controller {
    Model model;
    View view;
    Controller(Model tempModel, View tempView){
        model = tempModel;
        view = tempView;
    }
    void Grandprix() {
        for(int i = 0; i < model.trial; i++){
            for (int j = 0; j < model.raceCars.length; j++) {
                model.raceCars[j].Racing();
            }
            view.printResult(model.raceCars, model.raceCars.length);
        }
    }
}
