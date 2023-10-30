package racingcar;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
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
        ExceptionChecker.checkNameLength(carNames);
        ExceptionChecker.checkDuplicate(carNames);
        return carNames;
    }
    public int getRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        int round = ExceptionChecker.checkNumber(input);
        ExceptionChecker.checkNegativeNumber(round);
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
    public static void checkDuplicate(String[] carNames){
        if (Arrays.stream(carNames).distinct().count() != carNames.length){
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }
    }
    public static void checkNameLength(String[] carNames){
        for (String name : carNames){
            if (name.length() > 5 || name.isBlank()){
                throw new IllegalArgumentException("자동차 이름은 5글자 이하 또는 공백은 불가합니다.");
            }
        }
    }
    public static int checkNumber(String round){
        try {
            return Integer.parseInt(round);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자로 변환이 불가합니다.");
        }
    }

    public static void checkNegativeNumber(int round){
        if (round < 0){
            throw new IllegalArgumentException("음수는 입력 불가합니다.");
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
