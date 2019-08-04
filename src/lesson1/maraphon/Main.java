package lesson1.maraphon;

import lesson1.maraphon.competitors.*;
import lesson1.maraphon.obstacles.Cross;
import lesson1.maraphon.obstacles.Obstacle;
import lesson1.maraphon.obstacles.Wall;
import lesson1.maraphon.obstacles.Water;

public class Main {
    public static void main(String[] args) {


        Obstacle[] obstacles = {
                new Cross(randInt(50,90)),
                new Wall(randInt(1,2)),
                new Wall(randInt(1,2)),
                new Water(randInt(6,12))
        };

        Competitor[] competitors ={
                new Human("Bob"),
                new Cat("Barsik"),
                new Dog("Jack"),
                new Dog("Тузик") };

        Course c = new Course(obstacles); // Создаем полосу препятствий
        Team team = new Team("Команда", competitors); // Создаем команду
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(false); // Показываем результаты
    }

    public static int randInt(int min, int max){

        double x = (Math.random()*((max-min)+1))+min;
        int res = (int) x;
        return res;

    }
}
