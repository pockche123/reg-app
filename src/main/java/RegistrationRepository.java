public interface RegistrationRepository {
    void save(VehicleRegistration vehicleRegistration);
    int getTotalRegistrations();
    String getVehicleId(String regNumber);
    void remove(String vehicleRegNumber);
}
