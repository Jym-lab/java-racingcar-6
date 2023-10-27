package racingcar;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

class Car {
    private String name;
    private int position;

    public Car(String name){
        this.name = name;
        position = 0;
    }
    public void move(int randomNumber){
        if (randomNumber > 3){
            position++;
        }
    }
    public String getName(){
        return name;
    }

    public int getPosition() {
        return position;
    }
}

class Race{
    private List<Car> cars;

    public Race(String[] carNames) {
        cars = new ArrayList<>();
        for (String name : carNames){
            cars.add(new Car(name));
        }
    }

    public void StartRace(){
        for (Car car : cars){
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
