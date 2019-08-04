package lesson1.maraphon.competitors;

public class Human implements Competitor {

    String name;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;

    boolean active;

    public Human( String name) {
        this.name = name;
        this.maxRunDistance = 3000;
        this.maxJumpHeight = 2;
        this.maxSwimDistance = 100;
        this.active = true;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(name + " справился с кроссом на "+dist+" м.");
        } else {
            System.out.println(name + " провалил кросс на "+dist+" м.");
            active = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(name + " справился с прыжком на "+height+" м.");
        } else {
            System.out.println(name + " провалил прыжок на "+height+" м.");
            active = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (maxSwimDistance == 0) {
            System.out.println(name + " плавать не умеет");
            active = false;
            return;
        }
        if (dist <= maxSwimDistance) {
            System.out.println(name + " проплыл удачно дистанцию "+dist+" м.");
        } else {
            System.out.println(name + " не смог проплыть дистанцию "+dist+" м.");
            active = false;
        }
    }

    @Override
    public boolean isDistance() {
        return active;
    }

    @Override
    public void info() {
        if(this.isDistance()) {
            System.out.println(name + " на дистанции. Молодец.");
        } else {
            System.out.println(name + ", к сожалению, сошёл с дистанции");
        }
    }
}
