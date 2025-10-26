package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.stubs.AlwaysGoStrategy;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    void round_호출마다_스냅샷을_반환한다() {
        Cars cars = new Cars(Arrays.asList(
                new Car(new Name("pobi")),
                new Car(new Name("woni"))
        ));
        RacingGame game = new RacingGame(cars, new AlwaysGoStrategy());

        List<Car> snap1 = game.round();
        assertEquals(1, snap1.get(0).position());
        assertEquals(1, snap1.get(1).position());

        List<Car> snap2 = game.round();
        assertEquals(2, snap2.get(0).position());
        assertEquals(2, snap2.get(1).position());
    }

    @Test
    void winners는_Cars에_위임한다() {
        Cars cars = new Cars(Arrays.asList(
                new Car(new Name("pobi")),
                new Car(new Name("jun"))
        ));
        RacingGame game = new RacingGame(cars, new AlwaysGoStrategy());

        game.round();
        cars.asList().get(0).move(new AlwaysGoStrategy());

        List<String> winners = game.winners();
        assertEquals(List.of("pobi"), winners);
    }
}