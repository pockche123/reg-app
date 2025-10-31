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
        VehicleRegistration vehicleRegistration = new VehicleRegistration("AB01 CDE", 2001, "12345");
        VehicleRegistration vehicleRegistration2 = new VehicleRegistration("FG02 HJK", 2002, "678090");
        inMemoryVehicleRegistrationRepository.save(vehicleRegistration);
        inMemoryVehicleRegistrationRepository.save(vehicleRegistration2);

        // Act
        inMemoryVehicleRegistrationRepository.remove("AB01 CDE");


        //Assert
        assertEquals(1, inMemoryVehicleRegistrationRepository.getTotalRegistrations());
    }
}
