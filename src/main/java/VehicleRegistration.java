public class VehicleRegistration {
    private String registrationNumber;
    private int year;
    private String vehicleId;

    public VehicleRegistration(String registrationNumber, int year, String vehicleId){
        this.registrationNumber = registrationNumber;
        this.year = year;
        this.vehicleId = vehicleId;
    }
    public VehicleRegistration(){}

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public String toString() {
        return "VehicleRegistration{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", year=" + year +
                ", vehicleId='" + vehicleId + '\'' +
                '}';
    }
}
