import java.util.*;

interface BattleUnit{
    void attack();
    int getPower();
}

class ModernRobot implements BattleUnit{
    private final String name;
    private final int power;

    public ModernRobot(String name, int power){
        if(power<=0){
            System.out.println("Power canoot be negative");
            return;
        }

        this.name = name;
        this.power = power;
    }

    @Override
    public void attack(){
        System.out.println(this.name+" is attacking!");
    }
    @Override
    public int getPower(){
        return this.power;
    }
}

class OldRobot{
    private final String model;
    private final int laserPower;

    public OldRobot(String model, int laserPower){
        this.model = model;
        this.laserPower = laserPower;
    }
    public void fireLaser(){
        System.out.println(model + " fires a laser! ");
    }
    public int getLaserPower(){
        return laserPower;
    }
}

class OldRobotAdapter implements BattleUnit{
    private final OldRobot oldRobot;

    public OldRobotAdapter(OldRobot oldRobot) {
        this.oldRobot = oldRobot;
    }

    @Override
    public void attack() {
        oldRobot.fireLaser();
    }

    @Override
    public int getPower() {
        return oldRobot.getLaserPower();
    }
}


public class level3 {
}
