import java.util.*;

interface Mission{
    void display(String indent);
    int getDuration();
}

class SimpleMission implements Mission{
    private final String name;
    private final int duration;

    public SimpleMission(String name, int duration){
        if(duration<0){
            System.out.println("Duration must b non-negative");
        }
        this.name = name;
        this.duration = duration;
    }

    @Override
    public void display(String indent){
        System.out.println(indent+"- "+name+" ("+duration+" min)");
    }

    @Override
    public int getDuration(){
        return duration;
    }
}

class CompositeMission implements Mission{
    private final String name;
    private final List<Mission> subMissions = new ArrayList<>();

    public CompositeMission(String name){
        this.name = name;
    }

    public void add(Mission mission){
        if(mission == this){
            System.out.println("Mission cannot contain itself");
        }
        subMissions.add(mission);
    }

    public void remove(Mission mission){
        subMissions.remove(mission);
    }

    @Override
    public void display(String indent){
        System.out.println(indent+"+ "+name+" ("+getDuration()+"min)");
        for(Mission m: subMissions){
            m.display(indent+"    ");
        }
    }

    @Override
    public int getDuration(){
        int total = 0;
        for(Mission m: subMissions){
            total+= m.getDuration();
        }
        return total;
    }
}

public class Level2 {
    public static void main(String[] args){
        CompositeMission prep = new CompositeMission("Preparation");
        prep.add(new SimpleMission("Check fuel", 5));
        prep.add(new SimpleMission("Load Robots",10));

        CompositeMission launch = new CompositeMission("Launch Operation");
        launch.add(prep);
        launch.add(new SimpleMission("Deploy", 8));

        Mission root = launch;
        root.display("");
        System.out.println("Total duration: " + root.getDuration() + " min");
    }
}
