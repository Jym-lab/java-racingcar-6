package racingcar;


import camp.nextstep.edu.missionutils.Console;
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

    public void startRace(){
        for (Car car : cars){
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}

class Input {
    public String[] getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        return carNames;
    }
    public int getRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        int round = Integer.parseInt(Console.readLine());
        return round;
    }
}

class Result {
    public static void printRoundResult(List<Car> cars){
        for (Car car : cars){
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
    public static void winnerDeter(List<Car> cars){
        int max = -1;
        List<Car> winner = new ArrayList<>();
        for (Car car : cars){
            if (car.getPosition() > max){
                max = car.getPosition();
            }
        }
        for (Car car : cars){
            if (car.getPosition() == max){
                winner.add(car);
            }
        }
        printWinner(winner);
    }
    private static void printWinner(List<Car> cars){
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < cars.size(); i++){
            Car car = cars.get(i);
            if (i == cars.size() - 1){
                System.out.println(car);
            } else {
                System.out.print(car + ", ");
            }
        }
    }
}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
