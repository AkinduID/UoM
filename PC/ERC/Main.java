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

    public static void main(String args[]){
        StudyRoomReservationSystem studyRoomReservationSystem = new StudyRoomReservationSystem();
        studyRoomReservationSystem.studyRoomList.add(new StudyRoom(1, 10, true));
        studyRoomReservationSystem.studyRoomList.add(new StudyRoom(2, 20, true));
        studyRoomReservationSystem.studyRoomList.add(new StudyRoom(3, 30, true));
        studyRoomReservationSystem.studyRoomList.add(new StudyRoom(4, 40, true));
        studyRoomReservationSystem.displayStudyRoomStatus();

        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run(){
                studyRoomReservationSystem.reserveStudyRoom(1);
                studyRoomReservationSystem.reserveStudyRoom(2);
                studyRoomReservationSystem.reserveStudyRoom(3);
                studyRoomReservationSystem.reserveStudyRoom(4);
            }
        });
    }
}