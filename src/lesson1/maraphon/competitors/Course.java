package lesson1.maraphon.competitors;

import lesson1.maraphon.obstacles.Obstacle;

public class Course {

    Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        for (Competitor c:team.getMembers()) {
            for (Obstacle o:this.obstacles ) {
                o.doIt(c);
                if(!c.isDistance()) break;
            }
        }
    }
}
