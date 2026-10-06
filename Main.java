import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static ComplaintManager complaintManager = new ComplaintManager();
    static UserManager userManager = new UserManager();
    static Admin admin = new Admin();

    public static void main(String[] args) {

        // Load saved data
        userManager.setUsers(FileManager.loadUsers());
        complaintManager.setComplaints(FileManager.loadComplaints());

        while (true) {

            System.out.println("\n=======================================");
            System.out.println(" ROAD DAMAGE REPORTING SYSTEM ");
            System.out.println("=======================================");
            System.out.println("1. User Registration");
            System.out.println("2. User Login");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");
            System.out.print("Enter your choice : ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid Input!");
                continue;
            }

            switch (choice) {

                case 1:
                    registerUser();
                    break;

                case 2:
                    loginUser();
                    break;

                case 3:
                    adminLogin();
                    break;

                case 4:
                    FileManager.saveUsers(userManager.getUsers());
                    FileManager.saveComplaints(complaintManager.getComplaints());

                    System.out.println("Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }

        }

    }

    // ================= USER REGISTRATION =================

    public static void registerUser() {

        System.out.println("\n------ User Registration ------");

        System.out.print("Name : ");
        String name = sc.nextLine();

        System.out.print("Email : ");
        String email = sc.nextLine();

        System.out.print("Phone : ");
        String phone = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        boolean success =
                userManager.registerUser(name, email, phone, password);

        if (success) {
            FileManager.saveUsers(userManager.getUsers());
            System.out.println("Registration Successful.");
        } else {
            System.out.println("Email already exists.");
        }

    }

    // ================= USER LOGIN =================

    public static void loginUser() {

        System.out.println("\n------ User Login ------");

        System.out.print("Email : ");
        String email = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        User user = userManager.loginUser(email, password);

        if (user == null) {
            System.out.println("Invalid Email or Password.");
            return;
        }

        System.out.println("\nWelcome " + user.getName());

        while (true) {

            System.out.println("\n========== USER MENU ==========");
            System.out.println("1. Report Road Damage");
            System.out.println("2. View My Complaints");
            System.out.println("3. Track Complaint");
            System.out.println("4. Logout");
            System.out.print("Choice : ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid Input!");
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print("City : ");
                    String city = sc.nextLine();

                    System.out.print("Area : ");
                    String area = sc.nextLine();

                    System.out.print("Landmark : ");
                    String landmark = sc.nextLine();

                    System.out.println("\nDamage Types");
                    System.out.println("1. Pothole");
                    System.out.println("2. Crack");
                    System.out.println("3. Broken Road");
                    System.out.println("4. Water Logging");

                    System.out.print("Choice : ");

                    int damageChoice =
                            Integer.parseInt(sc.nextLine());

                    String damageType = "";

                    switch (damageChoice) {

                        case 1:
                            damageType = "Pothole";
                            break;

                        case 2:
                            damageType = "Crack";
                            break;

                        case 3:
                            damageType = "Broken Road";
                            break;

                        case 4:
                            damageType = "Water Logging";
                            break;

                        default:
                            damageType = "Other";

                    }

                    System.out.print("Description : ");
                    String description = sc.nextLine();

                    System.out.print("Priority (High/Medium/Low) : ");
                    String priority = sc.nextLine();

                    Complaint complaint =
                            new Complaint(
                                    user.getEmail(),
                                    city,
                                    area,
                                    landmark,
                                    damageType,
                                    description,
                                    priority);

                    complaintManager.addComplaint(complaint);

                    FileManager.saveComplaints(
                            complaintManager.getComplaints());

                    break;

                case 2:

                    complaintManager.viewUserComplaints(
                            user.getEmail());

                    break;

                case 3:

                    System.out.print("Complaint ID : ");

                    String id = sc.nextLine();

                    Complaint found =
                            complaintManager.searchComplaint(id);

                    if (found == null) {
                        System.out.println("Complaint Not Found");
                    } else {
                        found.displayComplaint();
                    }

                    break;

                case 4:

                    return;

                default:

                    System.out.println("Invalid Choice");

            }

        }

    }
        // ================= ADMIN LOGIN =================

    public static void adminLogin() {

        System.out.println("\n------ Admin Login ------");

        System.out.print("Username : ");
        String username = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        if (!admin.login(username, password)) {
            System.out.println("Invalid Admin Credentials.");
            return;
        }

        System.out.println("\nWelcome Admin!");

        while (true) {

            System.out.println("\n========== ADMIN MENU ==========");
            System.out.println("1. View All Complaints");
            System.out.println("2. Update Complaint Status");
            System.out.println("3. Delete Complaint");
            System.out.println("4. Complaint Statistics");
            System.out.println("5. View Registered Users");
            System.out.println("6. Logout");

            System.out.print("Enter Choice : ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid Input!");
                continue;
            }

            switch (choice) {

                case 1:

                    complaintManager.viewAllComplaints();
                    break;

                case 2:

                    System.out.print("Enter Complaint ID : ");
                    String id = sc.nextLine();

                    System.out.println("\nSelect Status");
                    System.out.println("1. Submitted");
                    System.out.println("2. Under Review");
                    System.out.println("3. Repair Assigned");
                    System.out.println("4. In Progress");
                    System.out.println("5. Completed");

                    System.out.print("Choice : ");

                    int statusChoice;

                    try {
                        statusChoice = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Invalid Input!");
                        break;
                    }

                    String status;

                    switch (statusChoice) {

                        case 1:
                            status = "Submitted";
                            break;

                        case 2:
                            status = "Under Review";
                            break;

                        case 3:
                            status = "Repair Assigned";
                            break;

                        case 4:
                            status = "In Progress";
                            break;

                        case 5:
                            status = "Completed";
                            break;

                        default:
                            status = "Submitted";
                    }

                    complaintManager.updateComplaintStatus(id, status);

                    FileManager.saveComplaints(
                            complaintManager.getComplaints());

                    break;

                case 3:

                    System.out.print("Enter Complaint ID : ");

                    String deleteId = sc.nextLine();

                    complaintManager.deleteComplaint(deleteId);

                    FileManager.saveComplaints(
                            complaintManager.getComplaints());

                    break;

                case 4:

                    complaintManager.complaintStatistics();

                    break;

                case 5:

                    userManager.viewUsers();

                    break;

                case 6:

                    return;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}