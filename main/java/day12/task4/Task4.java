package day12.task4;

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<MusicBand> mbList = new ArrayList<>();
        mbList.add(new MusicBand("Aerosmith", 1970));
        mbList.add(new MusicBand("Мираж", 1986));
        mbList.add(new MusicBand("Blink-182", 1992));
        mbList.add(new MusicBand("Depeche Mode", 1980));
        mbList.add(new MusicBand("Кар-мен", 1989));
        mbList.add(new MusicBand("Bon Jovi", 1983));
        mbList.add(new MusicBand("Scorpions", 1965));
        mbList.add(new MusicBand("Машина времени", 1969));
        mbList.add(new MusicBand("Ария", 1985));
        mbList.add(new MusicBand("Queen", 1970));
        mbList.add(new MusicBand("Metallica", 1981));
//        Collections.shuffle(mbList);

        addMemberInGroup(mbList, "Ария", "Михаил Житняков");
        addMemberInGroup(mbList, "Ария", "Владимир Холстинин");
        addMemberInGroup(mbList, "Ария", "Виталий Дубинин");
        addMemberInGroup(mbList, "Ария", "Сергей Попов");
        addMemberInGroup(mbList, "Ария", "Максим Удалов");
        addMemberInGroup(mbList, "Мираж", "Наталья Гулькина");
        addMemberInGroup(mbList, "Мираж", "Сергей Крылов");
        addMemberInGroup(mbList, "Мираж", "Андрей Гришин");
        addMemberInGroup(mbList, "Мираж", "Алексей Горбашов");
        addMemberInGroup(mbList, "Metallica", "James Hetfield");
        addMemberInGroup(mbList, "Metallica", "Lars Ulrich");
        addMemberInGroup(mbList, "Metallica", "Kirk Hammett");
        addMemberInGroup(mbList, "Metallica", "Robert Trujillo");

//        System.out.println("*** Group after 1980 *** \n" + groupAfter1980(mbList));
        System.out.println(mbList);
        MusicBand.transferMembers(mbList, "Мираж", "Metallica");
        MusicBand.printMembers(mbList, "Metallica");
        MusicBand.printMembers(mbList, "Мираж");
    }

    public static List<MusicBand> groupAfter1980(List<MusicBand> mbList) {
        List<MusicBand> lga1980 = new ArrayList<>();
        for(MusicBand i: mbList) {
            int tempYear = 1980;
            if(tempYear <= i.getYear()) { lga1980.add(i); }
        }
        return lga1980;
    }

    public static void addMemberInGroup(List<MusicBand> mbList, String groupName, String memberName) {
        for(MusicBand i: mbList) {
            if(i.getNameGroup().equals(groupName)) { i.getMembers().add(memberName); }
        }
    }

}

class MusicBand {
    private String nameGroup;
    private int year;
    private List<String> members;

    MusicBand(String name, int year) {
        this.nameGroup = name;
        this.year = year;
        this.members = new ArrayList<>();
    }

    String getNameGroup() { return nameGroup; }
    int getYear() { return year; }
    List<String> getMembers() { return members; }

    static void transferMembers(List<MusicBand> mbList, String nameGroup1, String nameGroup2 ) {
        List<String> tempMembersList = new ArrayList<>();
        for(MusicBand i : mbList) {
            if(i.getNameGroup().equals(nameGroup1)) {
                tempMembersList.addAll(i.getMembers());
                i.getMembers().clear();
            }
        }
        for(MusicBand i : mbList) {
            if(i.getNameGroup().equals(nameGroup2)) {
                i.getMembers().addAll(tempMembersList);
            }
        }
    }

    static void printMembers(List<MusicBand> mbList, String nameGroup) {
        for(MusicBand i : mbList) {
            if(i.getNameGroup().equals(nameGroup)) {
                System.out.println("На данный момент остав группы " + nameGroup + i.getMembers());
            }
        }
    }

    public String toString() { return  "\n" + this.nameGroup + " " + this.year + this.members; }
}



