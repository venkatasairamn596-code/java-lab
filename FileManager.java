import java.io.*;
import java.util.ArrayList;

public class FileManager {

    // Save Users
    public static void saveUsers(ArrayList<User> users) {

        try {

            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("users.dat"));

            out.writeObject(users);

            out.close();

        } catch (Exception e) {

            System.out.println("Unable to save users.");

        }

    }

    // Load Users
    @SuppressWarnings("unchecked")
    public static ArrayList<User> loadUsers() {

        try {

            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("users.dat"));

            ArrayList<User> users = (ArrayList<User>) in.readObject();

            in.close();

            return users;

        } catch (Exception e) {

            return new ArrayList<>();

        }

    }

    // Save Complaints
    public static void saveComplaints(ArrayList<Complaint> complaints) {

        try {

            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("complaints.dat"));

            out.writeObject(complaints);

            out.close();

        } catch (Exception e) {

            System.out.println("Unable to save complaints.");

        }

    }

    // Load Complaints
    @SuppressWarnings("unchecked")
    public static ArrayList<Complaint> loadComplaints() {

        try {

            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("complaints.dat"));

            ArrayList<Complaint> complaints = (ArrayList<Complaint>) in.readObject();

            in.close();

            return complaints;

        } catch (Exception e) {

            return new ArrayList<>();

        }

    }

}
