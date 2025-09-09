package edu.icet.elite.dao;

import edu.icet.elite.entity.Payment;
import java.util.List;
import java.util.Optional;

public interface PaymentDao {
    void save(Payment payment);
    Optional<Payment> findById(Integer id);
    List<Payment> findAll();
    List<Payment> findByStudentId(Integer studentId);
    void update(Payment payment);
    void delete(Payment payment);
}
