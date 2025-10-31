public class VehicleRegistrationService {

    private final RegistrationRepository registrationRepository;

    public VehicleRegistrationService(RegistrationRepository repository) {
        this.registrationRepository = repository;
    }


    public int getTotalRegistrationNumbers() {
        return registrationRepository.getTotalRegistrations();
    }

    public String getVehicleId(String regNumber) {
        return registrationRepository.getVehicleId(regNumber);
    }
}
