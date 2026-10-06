import java.io.Serializable;
import java.time.LocalDate;

public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;

    private static int counter = 1001;

    private String complaintId;
    private String userEmail;
    private String city;
    private String area;
    private String landmark;
    private String damageType;
    private String description;
    private String priority;
    private String status;
    private String date;

    // Constructor
    public Complaint(String userEmail, String city, String area,
            String landmark, String damageType,
            String description, String priority) {

        this.complaintId = "RD" + counter++;
        this.userEmail = userEmail;
        this.city = city;
        this.area = area;
        this.landmark = landmark;
        this.damageType = damageType;
        this.description = description;
        this.priority = priority;
        this.status = "Submitted";
        this.date = LocalDate.now().toString();
    }

    // Getters
    public String getComplaintId() {
        return complaintId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {
        return area;
    }

    public String getLandmark() {
        return landmark;
    }

    public String getDamageType() {
        return damageType;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    // Setter
    public void setStatus(String status) {
        this.status = status;
    }

    // Display Complaint
    public void displayComplaint() {

        System.out.println("\n====================================");
        System.out.println("Complaint ID : " + complaintId);
        System.out.println("User Email   : " + userEmail);
        System.out.println("City         : " + city);
        System.out.println("Area         : " + area);
        System.out.println("Landmark     : " + landmark);
        System.out.println("Damage Type  : " + damageType);
        System.out.println("Description  : " + description);
        System.out.println("Priority     : " + priority);
        System.out.println("Status       : " + status);
        System.out.println("Date         : " + date);
        System.out.println("====================================");
    }
}