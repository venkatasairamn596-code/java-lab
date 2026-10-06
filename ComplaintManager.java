import java.util.ArrayList;

public class ComplaintManager {

    private ArrayList<Complaint> complaints;

    // Constructor
    public ComplaintManager() {
        complaints = new ArrayList<>();
    }

    // Add Complaint
    public void addComplaint(Complaint complaint) {
        complaints.add(complaint);
        System.out.println("\n✅ Complaint submitted successfully!");
        System.out.println("Complaint ID : " + complaint.getComplaintId());
    }

    // View All Complaints
    public void viewAllComplaints() {

        if (complaints.isEmpty()) {
            System.out.println("\nNo complaints found.");
            return;
        }

        System.out.println("\n========== ALL COMPLAINTS ==========");

        for (Complaint complaint : complaints) {
            complaint.displayComplaint();
        }
    }

    // View Complaints of a Particular User
    public void viewUserComplaints(String email) {

        boolean found = false;

        for (Complaint complaint : complaints) {

            if (complaint.getUserEmail().equalsIgnoreCase(email)) {
                complaint.displayComplaint();
                found = true;
            }
        }

        if (!found) {
            System.out.println("\nNo complaints found for this user.");
        }
    }

    // Search Complaint by ID
    public Complaint searchComplaint(String complaintId) {

        for (Complaint complaint : complaints) {

            if (complaint.getComplaintId().equalsIgnoreCase(complaintId)) {
                return complaint;
            }
        }

        return null;
    }

    // Update Complaint Status
    public void updateComplaintStatus(String complaintId, String newStatus) {

        Complaint complaint = searchComplaint(complaintId);

        if (complaint == null) {
            System.out.println("\nComplaint not found.");
            return;
        }

        complaint.setStatus(newStatus);

        System.out.println("\nStatus updated successfully.");
    }

    // Delete Complaint
    public void deleteComplaint(String complaintId) {

        Complaint complaint = searchComplaint(complaintId);

        if (complaint == null) {
            System.out.println("\nComplaint not found.");
            return;
        }

        complaints.remove(complaint);

        System.out.println("\nComplaint deleted successfully.");
    }

    // Complaint Statistics
    public void complaintStatistics() {

        int submitted = 0;
        int review = 0;
        int assigned = 0;
        int progress = 0;
        int completed = 0;

        for (Complaint complaint : complaints) {

            switch (complaint.getStatus()) {

                case "Submitted":
                    submitted++;
                    break;

                case "Under Review":
                    review++;
                    break;

                case "Repair Assigned":
                    assigned++;
                    break;

                case "In Progress":
                    progress++;
                    break;

                case "Completed":
                    completed++;
                    break;
            }
        }

        System.out.println("\n========== COMPLAINT STATISTICS ==========");
        System.out.println("Total Complaints : " + complaints.size());
        System.out.println("Submitted        : " + submitted);
        System.out.println("Under Review     : " + review);
        System.out.println("Repair Assigned  : " + assigned);
        System.out.println("In Progress      : " + progress);
        System.out.println("Completed        : " + completed);
    }

    // Return Complaint List
    public ArrayList<Complaint> getComplaints() {
        return complaints;
    }

    // Set Complaint List (used while loading data)
    public void setComplaints(ArrayList<Complaint> complaints) {
        this.complaints = complaints;
    }
}