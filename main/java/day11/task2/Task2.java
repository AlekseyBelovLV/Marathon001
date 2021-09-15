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
    }
}

abstract class Hero {
    private int health;
    private int physAtt;
    private int magicAtt;
    private int physDef;// %
    private int magicDef;// %
    private int healHimself;
    private int healTeammate;

    int getHealth() { return health; }
    int getPhysAtt() { return physAtt; }
    int getMagicAtt() { return magicAtt; }
    int getPhysDef() { return physDef; }
    int getMagicDef() { return magicDef; }
    int getHealHimself() { return healHimself; }
    int getHealTeammate() { return healTeammate; }

    void setHealth(int health) { this.health = health; }
}

class Warrior extends Hero implements PhysAttack{
    private int health;
    private int physAtt;
    private int physDef;// %
    private int magicDef;// %

    Warrior() {
        this.health = 100;
        this.physAtt = 30;
        this.physDef = 80;
        this.magicDef = 0;
    }

    int getHealth() { return health; }
    int getPhysAtt() { return physAtt; }
    int getPhysDef() { return physDef; }
    int getMagicDef() { return magicDef; }

    void setHealth(int health) { this.health = health; }

    public void physicalAttack(Hero h) {
        if(h.getHealth() > 0) {
            if(h.getPhysDef() > 0) {
                double tempPhysDef = h.getPhysDef();
                int damage = this.physAtt -(int)(tempPhysDef / 100 * this.physAtt);
                if(h.getHealth() - damage <= 0) {
                    h.setHealth(0);
                } else {
                    h.setHealth(h.getHealth() - damage);
                }
            } else {
                if(h.getHealth() - this.physAtt <= 0) {
                    h.setHealth(0);
                } else {
                    h.setHealth(h.getHealth() - this.physAtt);
                }
            }
        } else {
            System.out.println(h + " уже убит.");
        }
    }

    public String toString() { return "Warrior health: " + this.health; }

}

class Paladin extends Hero implements PhysAttack, Healer {
    private int health;
    private int physAtt;
    private int physDef;// %
    private int magicDef;// %
    private int healHimself;
    private int healTeammate;

    Paladin() {
        this.health = 100;
        this.physAtt = 15;
        this.physDef = 50;
        this.magicDef = 20;
        this.healHimself = 25;
        this.healTeammate = 10;
    }

    int getHealth() { return health; }
    int getPhysAtt() { return physAtt; }
    int getPhysDef() { return physDef; }
    int getMagicDef() { return magicDef; }
    int getHealHimself() { return healHimself; }
    int getHealTeammate() { return healTeammate; }

    void setHealth(int health) { this.health = health; }

    public void physicalAttack(Hero h) {
        if(h.getHealth() > 0) {
            if(h.getPhysDef() > 0) {
                double tempPhysDef = h.getPhysDef();
                int damage = this.physAtt -(int)(tempPhysDef / 100 * this.physAtt);
                if(h.getHealth() - damage <= 0) {
                    h.setHealth(0);
                } else {
                    h.setHealth(h.getHealth() - damage);
                }
            } else {
                if(h.getHealth() - this.physAtt <= 0) {
                    h.setHealth(0);
                } else {
                    h.setHealth(h.getHealth() - this.physAtt);
                }
            }
        } else {
            System.out.println(h + " уже убит.");
        }
    }

    public void healHimself() {
        if (this.health + healHimself <= 100) {
            this.health += this.healHimself;
        } else if (this.health + healHimself > 100){
            this.health = 100;
        } else {
            System.out.println("Поздно пить баржоми.");
        }
    }

    public void healTeammate(Hero h) {
        if (h.getHealth() + this.healTeammate <= 100) {
            h.setHealth(h.getHealth() + this.healTeammate);
        } else if (h.getHealth() + this.healTeammate > 100) {
            h.setHealth(100);
        } else {
            System.out.println(h + " умер, его больше не выличить.");
        }
    }

    public String toString() { return "Paladin health: " + this.health; }

}

class Magician extends Hero implements PhysAttack, MagicAttack {
    private int health;
    private int physAtt;
    private int magicAtt;
    private int physDef;// %
    private int magicDef;// %

    Magician() {
        this.health = 100;
        this.physAtt = 5;
        this.magicAtt = 20;
        this.physDef = 0;
        this.magicDef = 80;
    }

    int getHealth() { return health; }
    int getPhysAtt() { return physAtt;}
    int getMagicAtt() { return magicAtt; }
    int getPhysDef() { return physDef; }
    int getMagicDef() { return magicDef; }

    void setHealth(int health) { this.health = health; }

    public void physicalAttack(Hero h) {
        if(h.getHealth() > 0) {
            if(h.getPhysDef() > 0) {
                double tempPhysDef = h.getPhysDef();
                int damage = this.physAtt -(int)(tempPhysDef / 100 * this.physAtt);
                if(h.getHealth() - damage <= 0) {
                    h.setHealth(0);
                } else {
                    h.setHealth(h.getHealth() - damage);
                }
            } else {
                if(h.getHealth() - this.physAtt <= 0) {
                    h.setHealth(0);
                } else {
                    h.setHealth(h.getHealth() - this.physAtt);
                }
            }
        } else {
            System.out.println(h + " уже убит.");
        }
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

    public String toString() { return "Magician health: " + this.health; }

}

class Shaman extends Hero implements PhysAttack, MagicAttack, Healer {
    private int health;
    private int physAtt;
    private int magicAtt;
    private int physDef;// %
    private int magicDef;// %
    private int healHimself;
    private int healTeammate;

    Shaman() {
        this.health = 100;
        this.physAtt = 10;
        this.magicAtt = 15;
        this.physDef = 20;
        this.magicDef = 20;
        this.healHimself = 50;
        this.healTeammate = 30;
    }

    int getHealth() { return health; }
    int getPhysAtt() { return physAtt; }
    int getMagicAtt() { return magicAtt; }
    int getPhysDef() { return physDef; }
    int getMagicDef() { return magicDef; }
    int getHealHimself() { return healHimself; }
    int getHealTeammate() { return healTeammate; }

    void setHealth(int health) { this.health = health; }

    public void physicalAttack(Hero h) {
        if(h.getHealth() > 0) {
            if(h.getPhysDef() > 0) {
                double tempPhysDef = h.getPhysDef();
                int damage = this.physAtt -(int)(tempPhysDef / 100 * this.physAtt);
                if(h.getHealth() - damage <= 0) {
                    h.setHealth(0);
                } else {
                    h.setHealth(h.getHealth() - damage);
                }
            } else {
                if(h.getHealth() - this.physAtt <= 0) {
                    h.setHealth(0);
                } else {
                    h.setHealth(h.getHealth() - this.physAtt);
                }
            }
        } else {
            System.out.println(h + " уже убит.");
        }
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
        if (this.health + healHimself <= 100) {
            this.health += this.healHimself;
        } else if (this.health + healHimself > 100){
            this.health = 100;
        } else {
            System.out.println("Поздно пить баржоми.");
        }
    }

    public void healTeammate(Hero h) {
        if (h.getHealth() + this.healTeammate <= 100) {
            h.setHealth(h.getHealth() + this.healTeammate);
        } else if (h.getHealth() + this.healTeammate > 100) {
            h.setHealth(100);
        } else {
            System.out.println(h + " умер, его больше не выличить.");
        }
    }

    public String toString() { return "Shaman health: " + this.health; }

}


