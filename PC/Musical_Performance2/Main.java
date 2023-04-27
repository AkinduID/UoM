import java.util.ArrayList;
import java.util.List;

//interface for the action backing up
// the backup method in this interface is used by backup singer and backup dancers
interface IBackup{   
    void backUp();
}

//Template for artists
//all artists have a name
abstract class Artist{
    String name;
    Artist(String name){
        this.name = name;
    }
}

//template for singers
//this is a subclasss of artist class
abstract class Singer extends Artist{
    //all singers inherit the name attribute of artists
    Singer(String name){
        super(name);
    }
}

//template for artist
//this is a subclasss of singer class
class main_Artist extends Singer {
    //main artist inherit the name attribute of artists
    main_Artist(String name){
        super(name);
    }
    void sing() {
        System.out.println("Main Artist " + name + " is singing.");
    }
}

//template for backup singers
//this is a subclasss of singer class
class backupSinger extends Singer implements IBackup{
    //all backup singers inherit the name attribute of artists
    backupSinger(String name){
        super(name);
    }
    @Override
    public void backUp() {
        System.out.println("Backup singer " + name + " is backing up the main artist by singing.");
    }
}

//template for backup dancers
//this is a subclasss of artist class
class backupDancer extends Artist implements IBackup {
    //all backup dancers inherit the name attribute of artists
    backupDancer(String name){
        super(name);
    }
    @Override
    public void backUp() {
        System.out.println("Backup dancer " + name + " is backing up the main artist by dancing.");
    }
}

//template for music tracks
class musicTrack{
    String name;
    double duration;
    musicTrack(String name, double duration){
        this.name=name;
        this.duration=duration;
    }
}

//template for a performance
abstract class Performance{
    String mainArtist;
    String performanceName;
    int year;
    String venue;
    List<backupDancer> backupDancers_list = new ArrayList<>();
    List<backupSinger> backupSingers_list = new ArrayList<>();
    List<musicTrack> trackList = new ArrayList<>();

    Performance(String mainArtist,String performanceName,int year,String venue){
        this.mainArtist=mainArtist;
        this.performanceName=performanceName;
        this.year=year;
        this.venue=venue;
    }
    //method to add music to the performance
    void addMusic(String name,double duration){
        //System.out.println("The song "+name+" is added to the track list");
            trackList.add(new musicTrack(name,duration));
    }
    //method to add backup singers to the performance
    void addBackupSingers(String name){
        //System.out.println("Backup Singer "+name+" is added to the performance");
        backupSingers_list.add(new backupSinger(name));
    }
    //method to add backup dancers to the performance
    void addBackupDancers(String name){
        //System.out.println("Backup Dancer "+name+" is added to the performance");
        backupDancers_list.add(new backupDancer(name));
    }
    //method to get venue
    void getVenue(){
        System.out.println("Venue: "+venue);
    }
    //method to get year
    void getYear(){
        System.out.println("Year: "+year);
    }
    //method to get performance name
    void getPerformancename(){
        System.out.println("performance Name: "+performanceName);
    }
    //method to change performance name
    void setPerformancename(String newName){
        this.performanceName=newName;
        System.out.println("New performance Name: "+this.performanceName);
    }
    //method to get performance status
    void initiatePerformance(){
        System.out.println("Welcome to the Performance "+performanceName+" by "+mainArtist+"!");
        main_Artist main_artist = new main_Artist(mainArtist);
        main_artist.sing();
        for(backupSinger Backup_Singer: backupSingers_list){
            Backup_Singer.backUp();
        }
        for(backupDancer Backup_Dancer: backupDancers_list){
            Backup_Dancer.backUp();
        }
    }
}

//template for live performance
//this is a sub class of performance
class livePerformance extends Performance{
    //live performance inherit the attributes of performance
    livePerformance(String mainArtist,String performanceName,int year,String venue){
        super(mainArtist, performanceName, year, venue);
    }
    //method to interact with audience
    void interact(){
        System.out.println("Artists are interacting with the audience");
    }
    // method to record live performance
    void record_live(){
        System.out.println("Performance is being recorded by drones");
    }
}

//template for studio performance
//this is a sub class of performance
class studioPerformance extends Performance{
    //studio performance inherit the attributes of performance
    studioPerformance(String mainArtist,String performanceName,int year,String venue){
        super(mainArtist, performanceName, year, venue);
    }
    //method to process audio
    void processAudio(){
        System.out.println("Audio is bieng processed");
    }
    //method to record studio performance
    void record_studio(){
        System.out.println("Performance is being recorded by studio camera");
    }
}

public class Main {
    public static void main (String[] args){
        livePerformance Eras = new livePerformance("Taylor Swift","Eras Tour",2023,"Glendale");
        String[] songList = {"Lavender Haze", "All Too Well", "the lakes", "The Man", "Love Story"};
        String[] singerList = {"Jeslyn", "Melanie"};
        String[] dancerList =  {"Stephanie", "Jake"};

        for(int i=0;i<songList.length;i++){
            Eras.addMusic(songList[i],i);
        }
        for(int i=0;i<singerList.length;i++){
            Eras.addBackupSingers(singerList[i]);
        }
        for(int i=0;i<dancerList.length;i++){
            Eras.addBackupDancers(dancerList[i]);
        }
        Eras.initiatePerformance();
    }
}