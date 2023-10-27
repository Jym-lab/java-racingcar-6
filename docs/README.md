# RacingCar
## 목표
* 객체 지향에 걸 맞게 하나의 클래스가 하나의 기능을 책임 지는 구조
* Input, Result, Car, Race, ExceptionChecker 클래스로 구분함
## 기능 구현 목록
1. Car 클래스
   1. 자동차 이름 (carName) 
   2. 현재 위치 (position)
   3. move시 동작 구현 (move)
2. Race 클래스
   1. move 메서드 실행하는 메서드 (StartRace)
   2. 입력 받은 값 만큼 Car 인스턴스를 생성하는 메서드 (CarGenerator)
3. Input 클래스
   1. 실제로 자동차 이름을 입력을 받는 메서드 (getCarNames)
   2. 라운드 횟수 입력 받는 메서드 (getRound)
4. Result 클래스
   1. 각 라운드 별 결과를 출력하는 메서드(printRoundResult)
   2. 승자를 출력하는 메서드(printWinner)
5. ExceptionChecker 클래스
   1. 사용자가 입력한 자동차 이름이 문제가 없는지 검사(checkCarNames)
   2. 입력한 라운드 수가 유효한지 - 숫자가 아닌 경우 등(checkRound)