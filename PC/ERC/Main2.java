package PC.ERC;

import java.util.ArrayList;
//import java.util.Random;

class StudyRoomUnavailableException extends Exception{
    public StudyRoomUnavailableException(String message){
        super(message);
    }
}

class StudyRoom{
    int roomNumber;
    int Capacity;
    boolean isAvailable;

    StudyRoom(int roomNumber, int Capacity, boolean isAvailable){
        this.roomNumber = roomNumber;
        this.Capacity = Capacity;
        this.isAvailable = isAvailable;
    }
    
    public void setRoomNumber(int roomNumber){
        this.roomNumber = roomNumber;
    }

    public void setCapacity(int Capacity){
        this.Capacity = Capacity;
    }

    public void setisAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    public int getRoomNumber(){
        return roomNumber;
    }

    public int getCapacity(){
        return Capacity;
    }

    public boolean getisAvailable(){
        return isAvailable;
    }
}

class StudyRoomReservationSystem{
    private ArrayList<StudyRoom> studyRoomList;

    StudyRoomReservationSystem(){
        this.studyRoomList = new ArrayList<>();
        //for(int i = 0; i < 10; i++){
            //int randomCapacity = random.nextInt(50);
            //studyRoomList.add(new StudyRoom(i, randomCapacity , true));
        //}  
    }


    public void reserveStudyRoom(int roomNumber){
        for(int i = 0; i < studyRoomList.size(); i++){
            if(studyRoomList.get(i).getRoomNumber() == roomNumber){
                if(studyRoomList.get(i).getisAvailable() == true){
                    studyRoomList.get(i).setisAvailable(false);
                    System.out.println("Room " + roomNumber + " is reserved.");
                }
                else{
                    System.out.println("Room " + roomNumber + " is not available.");
                }
            }
        }
    }

    public void releaseStudyRoom(int roomNumber){
        for(int i = 0; i < studyRoomList.size(); i++){
            if(studyRoomList.get(i).getRoomNumber() == roomNumber){
                if(studyRoomList.get(i).getisAvailable() == false){
                    studyRoomList.get(i).setisAvailable(true);
                    System.out.println("Room " + roomNumber + " is released.");
                }
                else{
                    System.out.println("Room " + roomNumber + " is already available.");
                }
            }
        }

    }

    public void displayStudyRoomStatus(){
        for(int i = 0; i < studyRoomList.size(); i++){
            String isAvailable = studyRoomList.get(i).getisAvailable() ? "available" : "not available";
            System.out.println("Room " + studyRoomList.get(i).getRoomNumber() + " is " + isAvailable + ".");
        }
    }
    
    public void addStudyRoom(StudyRoom room){
        studyRoomList.add(room);
    }
}


public class Main {
    public static void main(String[] args) {
        // Create StudyRoom objects
        StudyRoom room1 = new StudyRoom(1, 4,true);
        StudyRoom room2 = new StudyRoom(2, 6,true);
        StudyRoom room3 = new StudyRoom(3, 8,true);

        // Create StudyRoomReservationSystem
        StudyRoomReservationSystem reservationSystem = new StudyRoomReservationSystem();

        // Add study rooms to the reservation system
        reservationSystem.addStudyRoom(room1);
        reservationSystem.addStudyRoom(room2);
        reservationSystem.addStudyRoom(room3);

        // Display initial study room status
        reservationSystem.displayStudyRoomStatus();

        // Test Case 1: Single student reserving an available study room
        try {
            reservationSystem.reserveStudyRoom(1);
            System.out.println("Student 1 reserved Study Room 1.");
        } catch (StudyRoomUnavailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
