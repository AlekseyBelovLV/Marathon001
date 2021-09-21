package day11.task2;

public class Task2 {
    public static void main(String[] args) {
        Warrior war = new Warrior();
        Paladin pal = new Paladin();
        Magician mag = new Magician();
        Shaman sham = new Shaman();

        war.physicalAttack(pal);
        System.out.println(pal);
        pal.physicalAttack(mag);
        System.out.println(mag);
        sham.healTeammate(mag);
        System.out.println(mag);
        mag.magicalAttack(pal);
        System.out.println(pal);
        sham.physicalAttack(war);
        System.out.println(war);
        pal.healHimself();
        System.out.println(pal);
        for(int i = 0; i < 5; i++) {
            war.physicalAttack(mag);
            System.out.println(mag);
        }
        sham.healTeammate(mag);
        sham.healTeammate(mag);
        System.out.println(mag);

    }
}

abstract class Hero {
    private int health;
    private int physAtt;
    private int physDef;// %
    private int magicDef;// %

    Hero() { this.health = 100; }

    int getHealth() { return health; }
    int getPhysAtt() { return physAtt; }
    int getPhysDef() { return physDef; }
    int getMagicDef() { return magicDef; }

    void setHealth(int health) { this.health = health; }
    void setPhysAtt(int physAtt) { this.physAtt = physAtt; }
    void setPhysDef(int physDef) { this.physDef = physDef; }
    void setMagicDef(int magicDef) { this.magicDef = magicDef; }

    public void physicalAttack(Hero h) {
        if(h.getHealth() > 0) {
            double tempPhysDef = h.getPhysDef();
            int damage = this.getPhysAtt() -(int)(tempPhysDef / 100 * this.getPhysAtt());
            if(h.getHealth() - damage <= 0) {
                h.setHealth(0);
            } else {
                h.setHealth(h.getHealth() - damage);
            }
        } else {
            System.out.println("Герой уже убит.");
        }
    }
}

class Warrior extends Hero implements PhysAttack{
    Warrior() {
        super.setPhysAtt(30);
        super.setPhysDef(80);
        super.setMagicDef(0);
    }

    public String toString() { return "Warrior health: " + super.getHealth(); }
}

class Paladin extends Hero implements PhysAttack, Healer {
    private int healHimself;
    private int healTeammate;

    Paladin() {
        super.setPhysAtt(15);
        super.setPhysDef(50);
        super.setMagicDef(20);
        this.healHimself = 25;
        this.healTeammate = 10;
    }

    public void healHimself() {
        if(super.getHealth() > 0) {
            if (super.getHealth() + this.healHimself <= 100) {
                super.setHealth(super.getHealth() + this.healHimself);
            } else {
                this.setHealth(100);
            }
        } else {
            System.out.println("Труп ни лечится.");
        }
    }

    public void healTeammate(Hero h) {
        if(h.getHealth() > 0) {
            if (h.getHealth() + this.healTeammate <= 100) {
                h.setHealth(h.getHealth() + this.healTeammate);
            } else {
                h.setHealth(100);
            }
        } else {
            System.out.println("Герой умер, его больше не выличить.");
        }
    }

    public String toString() { return "Paladin health: " + this.getHealth(); } //?? Как правильно this или super ??

}

class Magician extends Hero implements PhysAttack, MagicAttack {
    private int magicAtt;

    Magician() {
        super.setPhysAtt(5);
        super.setPhysDef(0);
        super.setMagicDef(80);
        this.magicAtt = 20;
    }

    public void magicalAttack(Hero h) {
        if(h.getHealth() > 0) {
            if(h.getMagicDef() > 0) {
                double tempMagicDef = h.getMagicDef();
                int damage = this.magicAtt -(int)(tempMagicDef / 100 * this.magicAtt);
                if(h.getHealth() - damage <= 0) {
                    h.setHealth(0);
                } else {
                    h.setHealth(h.getHealth() - damage);
                }
            } else {
                if(h.getHealth() - this.magicAtt <= 0) {
                    h.setHealth(0);
                } else {
                    h.setHealth(h.getHealth() - this.magicAtt);
                }
            }
        } else {
            System.out.println(h + " уже убит.");
        }
    }

    public String toString() { return "Magician health: " + super.getHealth(); }
}

class Shaman extends Hero implements PhysAttack, MagicAttack, Healer {
    private int magicAtt;
    private int healHimself;
    private int healTeammate;

    Shaman() {
        super.setPhysAtt(10);
        super.setPhysDef(20);
        super.setMagicDef(20);
        this.magicAtt = 15;
        this.healHimself = 50;
        this.healTeammate = 30;
    }

    public void magicalAttack(Hero h) {
        if(h.getHealth() > 0) {
            if(h.getMagicDef() > 0) {
                double tempMagicDef = h.getMagicDef();
                int damage = this.magicAtt -(int)(tempMagicDef / 100 * this.magicAtt);
                if(h.getHealth() - damage <= 0) {
                    h.setHealth(0);
                } else {
                    h.setHealth(h.getHealth() - damage);
                }
            } else {
                if(h.getHealth() - this.magicAtt <= 0) {
                    h.setHealth(0);
                } else {
                    h.setHealth(h.getHealth() - this.magicAtt);
                }
            }
        } else {
            System.out.println(h + " уже убит.");
        }
    }

    public void healHimself() {
        if(super.getHealth() > 0) {
            if (super.getHealth() + this.healHimself <= 100) {
                super.setHealth(super.getHealth() + this.healHimself);
            } else {
                this.setHealth(100);
            }
        } else {
            System.out.println("Труп ни лечится.");
        }
    }

    public void healTeammate(Hero h) {
        if(h.getHealth() > 0) {
            if (h.getHealth() + this.healTeammate <= 100) {
                h.setHealth(h.getHealth() + this.healTeammate);
            } else {
                h.setHealth(100);
            }
        } else {
            System.out.println("Герой умер, его больше не выличить.");
        }
    }

    public String toString() { return "Shaman health: " + super.getHealth(); }
}


