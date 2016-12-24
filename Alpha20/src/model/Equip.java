package model;
public class Equip {
    int id;
    String name; //  name of equip
    String description; //description of equip
    String type; //type of equip
    int amount; //value 
    int nOF; //the number of features - ilość cech przedmiotu
    int dmg; //damage
    int def; //defence
    int speed; 
    
      
    public Equip(){}

    public Equip(int id, String name, String description, String type, int amount, int nOF, int dmg, int def, int speed) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.nOF = nOF;
        this.dmg = dmg;
        this.def = def;
        this.speed = speed;
    }
    
    
    //getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public int getnOF() {
        return nOF;
    }

    public int getDmg() {
        return dmg;
    }

    public int getDef() {
        return def;
    }

    public int getSpeed() {
        return speed;
    }
    
    
    
    
    
    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setnOF(int nOF) {
        this.nOF = nOF;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    
}
