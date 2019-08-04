package lesson1.maraphon.competitors;

public class Team {
    String teamName;
    Competitor[] members;

    public Team(String name, Competitor[] competitors) {
        this.teamName = name;
        this.members = competitors;
    }

    public Competitor[] getMembers() {
        return this.members;
    }

    public void ongoingResults() {
        for (Competitor c:members) {
            c.info();
        }
    }

    public void showResults(boolean onlyOnDistance) {
        System.out.println("");
        System.out.println("Результаты команды «"+this.teamName+"»");
        for (Competitor c:members) {
            if(onlyOnDistance && !c.isDistance()) {
                continue;
            }
            c.info();
        }
    }

}
