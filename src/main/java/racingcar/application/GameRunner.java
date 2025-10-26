package racingcar.application;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class GameRunner {

    private final InputView inputView;
    private final OutputView outputView;

    public GameRunner(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String namesRaw = inputView.readNames();
        List<Name> names = NameParser.parse(namesRaw);
        List<Car> carList = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        Cars cars = new Cars(carList);

        String attemptsRaw = inputView.readAttempts();
        Attempts attempts = new Attempts(attemptsRaw);

        outputView.printTitle();

        RacingGame game = new RacingGame(cars, new RandomMoveStrategy());
        for (int i = 0; i < attempts.value(); i++) {
            List<Car> snapshot = game.round();
            outputView.printRound(snapshot);
        }

        outputView.printWinners(game.winners());
    }
}
