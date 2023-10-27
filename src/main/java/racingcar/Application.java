package racingcar;


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

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
