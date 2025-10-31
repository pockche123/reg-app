import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InMemoryVehicleRegistrationRepositoryTest {

    private InMemoryVehicleRegistrationRepository inMemoryVehicleRegistrationRepository;

    @BeforeEach
    public void setup(){
        inMemoryVehicleRegistrationRepository = new InMemoryVehicleRegistrationRepository();
    }

    @AfterEach
    public void tearDown(){
        InMemoryDatabase.getInstance().clearAll();
    }

    @Test
    public void test_addVehicleRegistration_throwsIllegalArgumentException(){
        VehicleRegistration vehicleRegistration = new VehicleRegistration();
        vehicleRegistration.setVehicleId("12345");
        vehicleRegistration.setYear(2014);

        assertThrows(IllegalArgumentException.class, () -> inMemoryVehicleRegistrationRepository.save(vehicleRegistration));
    }

    @Test
    public void test_removeVehicleRegistration_removesFromRepository(){
        // Arrange
        VehicleRegistration vehicleRegistration = new VehicleRegistration();
        vehicleRegistration.setRegistrationNumber("AB01 CDE");
        vehicleRegistration.setYear(2001);
        vehicleRegistration.setVehicleId("12345");
        
        VehicleRegistration vehicleRegistration2 = new VehicleRegistration();
        vehicleRegistration2.setRegistrationNumber("FG02 HJK");
        vehicleRegistration2.setYear(2002);
        vehicleRegistration2.setVehicleId("678090");
        
        inMemoryVehicleRegistrationRepository.save(vehicleRegistration);
        inMemoryVehicleRegistrationRepository.save(vehicleRegistration2);

        // Act
        inMemoryVehicleRegistrationRepository.remove("AB01 CDE");

        //Assert
        assertEquals(1, inMemoryVehicleRegistrationRepository.getTotalRegistrations());
    }
}
