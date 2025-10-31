import java.util.Optional;

public class VehicleRegistrationService {

    private final RegistrationRepository registrationRepository;

    public VehicleRegistrationService(RegistrationRepository repository) {
        this.registrationRepository = repository;
    }


    public int getTotalRegistrationNumbers() {
        return registrationRepository.getTotalRegistrations();
    }

    public Optional<String> getVehicleId(String regNumber) {
        String vehicleId =  registrationRepository.getVehicleId(regNumber);
        return Optional.ofNullable(vehicleId);
    }
}
