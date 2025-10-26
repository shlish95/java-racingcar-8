package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public void printTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRound(List<Car> cars) {
        for (Car car : cars) {
            String bars = "-".repeat(Math.max(0, car.position()));
            System.out.println(car.name() + " : " + bars);
        }

        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
