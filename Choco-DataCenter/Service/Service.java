package Service;

import java.time.LocalDateTime;

// Done by Clark Potter
public class Service {
    private String dateOfService;
    private LocalDateTime receivedDateTime;
    private String memberName;
    private String memberNumber;
    private double fee;
    private int consultations;
    
    // Constructor
    public Service(String dateOfService, LocalDateTime receivedDateTime, String memberName, String memberNumber, double fee, int consultations) {
        this.dateOfService = dateOfService;
        this.receivedDateTime = receivedDateTime;
        this.memberName = memberName;
        this.memberNumber = memberNumber;
        this.fee = fee;
        this.consultations = consultations;
    }

    // Getters and Setters
    public String getDateOfService() {
        return dateOfService;
    }

    public void setDateOfService(String dateOfService) {
        this.dateOfService = dateOfService;
    }

    public LocalDateTime getReceivedDateTime() {
        return receivedDateTime;
    }

    public void setReceivedDateTime(LocalDateTime receivedDateTime) {
        this.receivedDateTime = receivedDateTime;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getConsultations() {
        return consultations;
    }

    public void setConsultations(int consultations) {
        this.consultations = consultations;
    }

    @Override
    public String toString() {
        return String.format("%-12s%-20s%-28s%-15s$%-8.2f%-3d", dateOfService, receivedDateTime, memberName, memberNumber, fee, consultations);
    }
}