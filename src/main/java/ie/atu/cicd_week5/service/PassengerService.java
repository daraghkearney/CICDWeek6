package ie.atu.cicd_week5.service;

import ie.atu.cicd_week5.controller.errorHandling.DuplicateException;
import ie.atu.cicd_week5.model.Passenger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    private final List<Passenger> store = new ArrayList<>();

    public List<Passenger> findAll() {
        return new ArrayList<>(store);
    }

    public Optional<Passenger> findById(String id) {
        for (Passenger p : store) {
            if (p.getPassengerId().equals(id)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public Passenger create(Passenger p) {
        for (Passenger pass : store) {
            if (findById(p.getPassengerId()).isPresent()) {
                throw new DuplicateException("Passenger with id: " + p.getPassengerId() + " already exists");
            }
        }
        store.add(p);
        return p;
    }
    // update existing passenger’s name/email
    public Optional<Passenger> update(String id, Passenger updated) {
        for (Passenger p : store) {
            if (p.getPassengerId().equals(id)) {
                p.setName(updated.getName());
                p.setEmail(updated.getEmail());
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    // delete passenger by id
    public boolean deleteById(String id) {
        return store.removeIf(p -> p.getPassengerId().equals(id));
    }
}

