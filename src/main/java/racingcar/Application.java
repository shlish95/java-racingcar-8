package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.application.GameRunner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {

        try {
            new GameRunner(new InputView(), new OutputView()).run();
        } finally {
            Console.close();
        }
    }
}
