import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class VehicleRegistrationServiceTest {

    private VehicleRegistrationService registrationService;
    private RegistrationRepository repository;

    @BeforeEach
    public void setUp(){
        repository = new InMemoryVehicleRegistrationRepository();
        registrationService = new VehicleRegistrationService(repository);

    }

    @AfterEach
    public void tearDown(){
        InMemoryDatabase.getInstance().clearAll();
    }


    @Test
    public void test_findTotalRegistrationNumbers_returnsCount(){
        VehicleRegistration reg1 = new VehicleRegistration();
        reg1.setRegistrationNumber("AB01 CDE");
        reg1.setYear(2001);
        reg1.setVehicleId("12345");
        
        VehicleRegistration reg2 = new VehicleRegistration();
        reg2.setRegistrationNumber("FG02 HJK");
        reg2.setYear(2002);
        reg2.setVehicleId("67890");
        
        repository.save(reg1);
        repository.save(reg2);

        int actual = registrationService.getTotalRegistrationNumbers();

        assertEquals(2, actual);
    }

    @Test
    public void test_givenRegistrationNumberProvided_returnsVehicleId(){
        // Arrange
        VehicleRegistration reg1 = new VehicleRegistration();
        reg1.setRegistrationNumber("AB01 CDE");
        reg1.setYear(2001);
        reg1.setVehicleId("12345");
        
        VehicleRegistration reg2 = new VehicleRegistration();
        reg2.setRegistrationNumber("L33T H4X");
        reg2.setYear(2022);

        repository.save(reg1);
        repository.save(reg2);
        String regNumber = "AB01 CDE";
        String regNumber2 = "L33T H4X";

        // Act
        Optional<String> actualVehicleId = registrationService.getVehicleId(regNumber);
        Optional<String> actualVehicleId2 = registrationService.getVehicleId(regNumber2);

        // Assert
        assertEquals("12345", actualVehicleId.get());
        assertFalse(actualVehicleId2.isPresent());

    }







}
