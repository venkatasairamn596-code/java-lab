import java.util.ArrayList;

public class UserManager {

    private ArrayList<User> users;

    // Constructor
    public UserManager() {
        users = new ArrayList<>();

        // Default user (for testing)
        users.add(new User("Sairam", "sairam@gmail.com", "9876543210", "1234"));
    }

    // Register User
    public boolean registerUser(String name, String email, String phone, String password) {

        // Check if email already exists
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return false;
            }
        }

        User newUser = new User(name, email, phone, password);
        users.add(newUser);

        return true;
    }

    // Login User
    public User loginUser(String email, String password) {

        for (User user : users) {

            if (user.getEmail().equalsIgnoreCase(email)
                    && user.getPassword().equals(password)) {

                return user;
            }
        }

        return null;
    }

    // View All Users
    public void viewUsers() {

        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }

        System.out.println("\n========== REGISTERED USERS ==========");

        for (User user : users) {
            user.displayUser();
        }
    }

    // Check if Email Exists
    public boolean emailExists(String email) {

        for (User user : users) {

            if (user.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }

        return false;
    }

    // Get User List
    public ArrayList<User> getUsers() {
        return users;
    }

    // Set User List
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
