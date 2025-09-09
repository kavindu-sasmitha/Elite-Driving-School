package edu.icet.elite.bo;

import edu.icet.elite.dto.PaymentDto;
import edu.icet.elite.exception.PaymentException;

import java.util.List;

public interface PaymentBo {
    void processPayment(PaymentDto paymentDto) throws PaymentException;
    List<PaymentDto> getPaymentsByStudent(Integer studentId);
    List<PaymentDto> getAllPayments();
}
