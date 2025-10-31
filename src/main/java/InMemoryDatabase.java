import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase {
    private static InMemoryDatabase instance;

    private final Map<String, VehicleRegistration> vehicleRegistrations = new HashMap<>();

    private InMemoryDatabase(){}

    public static InMemoryDatabase getInstance(){
        if(instance == null){
            instance = new InMemoryDatabase();
        }
        return instance;
    }

    public Map<String, VehicleRegistration> getRegistrations() {
        return vehicleRegistrations;
    }

    public void clearAll(){
        vehicleRegistrations.clear();
    }

}
