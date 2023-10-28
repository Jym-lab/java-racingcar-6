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
        for (int i = 0; i < carNames.length; i++){
            carNames[i] = carNames[i].strip();
        }
        ExceptionChecker.checkCarNames(carNames);
        return carNames;
    }
    public int getRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        String round = Console.readLine();
        int roundNum = ExceptionChecker.checkRound(round);
        return roundNum;
    }
}

class Result {
    public static void printRoundResult(List<Car> cars){
        for (Car car : cars){
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
    public static List<Car> winnerDeter(List<Car> cars){
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
        return winner;
    }
    public static void printWinner(List<Car> cars){
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < cars.size(); i++){
            Car car = cars.get(i);
            if (i == cars.size() - 1){
                System.out.println(car.getName());
            } else {
                System.out.print(car.getName() + ", ");
            }
        }
    }
}

class ExceptionChecker {
    public static void checkCarNames(String[] carNames){
        for (String name : carNames){
            if (name.length() > 5){
                throw new IllegalArgumentException("The car name is longer than 5 characters.");
            }
        }
    }

    public static int checkRound(String round){
        try{
            int number = Integer.parseInt(round);
            if (number < 0){
                throw new IllegalArgumentException("Negative numbers cannot be entered");
            }
            return number;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("The input round value is not a number!");
        }
    }
}

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        String[] carNames = input.getCarNames();
        int round = input.getRound();

        Race race = new Race(carNames);
        for (int i = 0; i < round; i++){
            race.startRace();
            Result.printRoundResult(race.getCars());
        }
        List<Car> winner = Result.winnerDeter(race.getCars());
        Result.printWinner(winner);
    }
}
