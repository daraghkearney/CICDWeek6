package ie.atu.cicd_week5.service;

import ie.atu.cicd_week5.model.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PassengerServiceTest {

    private PassengerService service;

    @BeforeEach
    void setUp() {
        service = new PassengerService();
    }

    @Test
    void createThenFindById() {
        Passenger p = Passenger.builder()
                .passengerId("P1")
                .name("Daragh")
                .email("daragh@email.com")
                .build();

        service.create(p);

        Optional<Passenger> found = service.findById("P1");
        assertTrue(found.isPresent());
        assertEquals("Daragh", found.get().getName());
    }
    // Update success
    @Test
    void updateExistingPassenger() {
        Passenger p = Passenger.builder().passengerId("P1").name("Old").email("old@email.com").build();
        service.create(p);

        Passenger updated = Passenger.builder().passengerId("P1").name("New").email("new@email.com").build();
        Optional<Passenger> result = service.update("P1", updated);

        assertTrue(result.isPresent());
        assertEquals("New", result.get().getName());
        assertEquals("new@email.com", result.get().getEmail());
    }

    // Update not found
    @Test
    void updateNonExistingPassenger() {
        Passenger updated = Passenger.builder().passengerId("X").name("Ghost").email("ghost@email.com").build();
        Optional<Passenger> result = service.update("X", updated);
        assertTrue(result.isEmpty());
    }

    // Delete success
    @Test
    void deleteExistingPassenger() {
        Passenger p = Passenger.builder().passengerId("P2").name("DeleteMe").email("del@email.com").build();
        service.create(p);
        boolean deleted = service.deleteById("P2");
        assertTrue(deleted);
        assertTrue(service.findById("P2").isEmpty());
    }

    // Delete not found
    @Test
    void deleteNonExistingPassenger() {
        boolean deleted = service.deleteById("DoesNotExist");
        assertFalse(deleted);
    }
}
