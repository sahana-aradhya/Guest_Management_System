import java.util.Scanner;
public class GuestManagementSystem {
    static String [] guest = new String[10];
    static Scanner scanner = new Scanner(System.in);
    public static void main(String [] args) {

        insertTestNames();

        do{
            displayGuests(); 
            displayMenu();
            int option = getOption();
            if(option == 1){
            addGuest();
            }
            else if(option == 2){
                insertGuest();
            }
            else if(option == 3){
                renameGuest();
            }
            else if(option == 4) {
                removeGuest();
            }
            else if(option==5) {
            break;
            }
            else {
                System.out.println("Invalid option, try with the valid option.");
            }

    } while(true);
    scanner.close();
    }

    static void displayGuests(){
        Boolean initial = true;
        System.out.println("_______________________________________________________________________");
            System.out.println(("- Guest -\n\n"));
            for(int i=0; i<guest.length; i++) {
                if(guest[i] != null){ // display the guest only if it is not equal to null
                System.out.println((i+1)+ ". " + guest[i]);
                initial = false; // if it has guest name then set initial value to false (Boolean datatype)
                }
            }
            if(initial) {
                System.out.println("Guest list is empty");
            }
    }

    static void insertGuest() {
        System.out.print("Enter the index where you want to insert a new guest: ");
        int insertnum = scanner.nextInt();
        scanner.nextLine();
        System.out.print("What name do you want to enter at "+insertnum+" position: ");
        String insertname = scanner.nextLine();
        for(int i= guest.length-1; i>insertnum-1; i--){
            guest[i] = guest[i-1]; // to move to name of guest to next position
        }
        if( insertnum>=1 && insertnum<= guest.length) {
            guest[insertnum-1] = insertname;
        }
        else {
            System.out.println("Invalid input, Try with valid input");
        }
    }

    static void renameGuest() {
        System.out.print("Enter the guest number you want to rename: ");
        int rnum = scanner.nextInt();
        scanner.nextLine();
        if(rnum >=1 && rnum<=guest.length && guest[rnum]!=null){
            System.out.print("\nEnter the new name for the guest at index "+(rnum)+" :");
            guest[rnum-1] = scanner.nextLine(); 
        }
        else {
            System.out.println("Error: There is no guest at this index.");
        }
    }

    public static void displayMenu() {
        System.out.println("_______________________________________________________________________");
            System.out.println(" - Menu -");
            System.out.println(" ");
        System.out.println("1 - Add guest ");
        System.out.println("2 - Insert");
        System.out.println("3 - Rename");
        System.out.println("4 - Delete a guest");
        System.out.println("5 - Exit\n");
    }

    public static int getOption() {
        System.out.print("Enter Option:");
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println(" ");
        return option;
    }

    static void addGuest(){
        for(int i=0;i<guest.length;i++) {
                if(guest[i]==null) {
                System.out.print("Name: ");
                guest[i]= scanner.nextLine();
                break;
                }
            }
        }
    
    static void removeGuest() {
        System.out.print("Enter the index of the person you want to delete: ");
        int num = scanner.nextInt();
        if(num >= 1 && num <= guest.length && guest[num-1]!=null) {
            if(guest[num - 1] != null) { 
                for(int j = num - 1; j < guest.length - 1; j++) {
                    guest[j] = guest[j + 1]; // to move the name in forward direction only if that index is not equal to null
                }
                guest[guest.length - 1] = null; // after deleting the name the last element of guest array is set to null
                System.out.println("Guest deleted successfully.");
            } 
            else {
                System.out.println("Error: There is no guest at this index.");
            }
        } 
        else {
            System.out.println("\n Error: Invalid index.");
        }
    }

        static void insertTestNames() {
            guest[0]="Sahana";
            guest[1]="Bhuvan";
            guest[2]="Aishu";
            guest[3]="Alice";
            guest[4]="Bob";
        }
    }

