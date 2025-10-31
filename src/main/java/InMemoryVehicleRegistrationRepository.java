import java.util.HashMap;
import java.util.Map;

public class InMemoryVehicleRegistrationRepository implements  RegistrationRepository {
    private final Map<String, VehicleRegistration> registrationMap = new HashMap<>();

    @Override
    public void save(VehicleRegistration vehicleRegistration){
        if(vehicleRegistration == null){
            throw new IllegalArgumentException("VehicleRegistration cannot be null");
        }
        if(vehicleRegistration.getRegistrationNumber() == null){
            throw new IllegalArgumentException("Vehicle Reg Number cannot be null");
        }
        registrationMap.put(vehicleRegistration.getRegistrationNumber(), vehicleRegistration);
    }

    @Override
    public int getTotalRegistrations(){
        return registrationMap.size();
    }

    @Override
    public String getVehicleId(String regNumber) {
        VehicleRegistration registration = registrationMap.get(regNumber);
        return registration != null ? registration.getVehicleId() : null;
    }

    @Override
    public void remove(String vehicleRegNumber) {
        registrationMap.remove(vehicleRegNumber);
    }
}
