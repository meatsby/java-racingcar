package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(car.startEngine());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getChampions() {
        int highScore = 0;
        for (Car car : cars) {
            highScore = car.comparePosition(highScore);
        }

        List<String> championNames = new ArrayList<>();
        for (Car car : cars) {
            checkChampion(car, highScore, championNames);
        }

        return championNames;
    }

    private void checkChampion(Car car, int highScore, List<String> championNames) {
        if (car.isChampion(highScore)) {
            championNames.add(car.getName());
        }
    }
}
