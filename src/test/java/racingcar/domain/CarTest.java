package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.stubs.AlwaysGoStrategy;
import racingcar.domain.stubs.NeverGoStrategy;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 전략이_true면_전진한다() {
        Car car = new Car(new Name("pobi"));
        car.move(new AlwaysGoStrategy());
        car.move(new AlwaysGoStrategy());
        assertEquals(2, car.position());
    }

    @Test
    void 전략이_false면_정지한다() {
        Car car = new Car(new Name("woni"));
        car.move(new NeverGoStrategy());
        car.move(new NeverGoStrategy());
        assertEquals(0, car.position());
    }
}