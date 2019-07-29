package lesson1.maraphon.competitors;

public class Animal implements Competitor {
    String type;
    String name;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;

    boolean onDistance;

    public Animal(String type, String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(type + " " + name + " справился с кроссом на "+dist+" м.");
        } else {
            System.out.println(type + " " + name + " провалил кросс на "+dist+" м.");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(type + " " + name + " справился с прыжком на "+height+" м.");
        } else {
            System.out.println(type + " " + name + " провалил прыжок на "+height+" м.");
            onDistance = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (maxSwimDistance == 0) {
            System.out.println(type + " " + name + " плавать не умеет");
            onDistance = false;
            return;
        }
        if (dist <= maxSwimDistance) {
            System.out.println(type + " " + name + " проплыл удачно дистанцию "+dist+" м.");
        } else {
            System.out.println(type + " " + name + " не смог проплыть дистанцию "+dist+" м.");
            onDistance = false;
        }
    }

    @Override
    public boolean isDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        if(this.isDistance()) {
            System.out.println(type + " " + name + " на дистанции. Молодец.");
        } else {
            System.out.println(type + " " + name + ", к сожалению, сошёл с дистанции");
        }
    }
}
