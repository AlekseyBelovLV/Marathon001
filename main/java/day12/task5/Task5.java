package day12.task5;

import java.util.ArrayList;
import java.util.List;

public class Task5 {
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

        addMemberInGroup(mbList, "Ария", "Михаил Житняков", 1979);
        addMemberInGroup(mbList, "Ария", "Владимир Холстинин", 1958);
        addMemberInGroup(mbList, "Ария", "Виталий Дубинин", 1958);
        addMemberInGroup(mbList, "Ария", "Сергей Попов", 1959);
        addMemberInGroup(mbList, "Ария", "Максим Удалов", 1966);
        addMemberInGroup(mbList, "Мираж", "Наталья Гулькина", 1964);
        addMemberInGroup(mbList, "Мираж", "Сергей Крылов", 1962);//Но это не точно.
        addMemberInGroup(mbList, "Мираж", "Андрей Гришин", 1965);//Но это не точно.
        addMemberInGroup(mbList, "Мираж", "Алексей Горбашов", 1961);
        addMemberInGroup(mbList, "Metallica", "James Hetfield", 1963);
        addMemberInGroup(mbList, "Metallica", "Lars Ulrich", 1963);
        addMemberInGroup(mbList, "Metallica", "Kirk Hammett", 1962);
        addMemberInGroup(mbList, "Metallica", "Robert Trujillo", 1964);

//        System.out.println("*** Group after 1980 *** \n" + groupAfter1980(mbList));
        System.out.println(mbList);
        MusicBand.transferMembers(mbList, "Metallica", "Мираж");
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

    public static void addMemberInGroup(List<MusicBand> mbList, String groupName, String memberName, int yearOfBirth) {
        for(MusicBand i: mbList) {
            if(i.getNameGroup().equals(groupName)) { i.getMembers().add(new GroupMembers(memberName, yearOfBirth)); }
        }
    }

}

class GroupMembers {
    private String nameMember;
    private int yearOfBirthMember;

    GroupMembers(String nameMembers, int yearOfBirthMember) {
        this.nameMember = nameMembers;
        this.yearOfBirthMember = yearOfBirthMember;
    }

    public String toString() { return this.nameMember + " " + this.yearOfBirthMember; }
}

class MusicBand {
    private String nameGroup;
    private int year;
    private List<GroupMembers> members;

    MusicBand(String name, int year) {
        this.nameGroup = name;
        this.year = year;
        this.members = new ArrayList<>();
    }

    String getNameGroup() { return nameGroup; }
    int getYear() { return year; }
    List<GroupMembers> getMembers() { return members; }

    static void transferMembers(List<MusicBand> mbList, String nameGroup1, String nameGroup2 ) {
        int tempIndexGroup1 = 0;
        int tempIndexGroup2 = 0;
        for(MusicBand i : mbList) {
            if(nameGroup1.equals(i.getNameGroup())) { tempIndexGroup1 = mbList.indexOf(i); }
            if(nameGroup2.equals(i.getNameGroup())) { tempIndexGroup2 = mbList.indexOf(i); }
        }
        mbList.get(tempIndexGroup2).getMembers().addAll(mbList.get(tempIndexGroup1).getMembers());
        mbList.get(tempIndexGroup1).getMembers().clear();
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
