import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private String phone;
    private String password;

    // Constructor
    public User(String name, String email, String phone, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    // Display User Details
    public void displayUser() {
        System.out.println("\n========== USER DETAILS ==========");
        System.out.println("Name   : " + name);
        System.out.println("Email  : " + email);
        System.out.println("Phone  : " + phone);
        System.out.println("==================================");
    }
}