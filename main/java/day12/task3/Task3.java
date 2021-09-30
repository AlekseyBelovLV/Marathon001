package day12.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task3 {
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
        System.out.println(mbList);
        Collections.shuffle(mbList);
        System.out.println(mbList);
        System.out.println("*** Group after 1980 *** \n" + groupAfter1980(mbList));
    }

    public static List<MusicBand> groupAfter1980(List<MusicBand> mbList) {
        List<MusicBand> lga1980 = new ArrayList<>();
        for(MusicBand i: mbList) {
            int tempYear = 1980;
            if(tempYear <= i.getYear()) { lga1980.add(i); }
        }
        return lga1980;
    }
}

class MusicBand {
    private String name;
    private int year;

    MusicBand(String name, int year) {
        this.name = name;
        this.year = year;
    }

    int getYear() { return year; }
    public String toString() { return  "\n" + this.name + " " + this.year; }
}