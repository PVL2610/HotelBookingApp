package com.example.hotelbooking_app.Booking.Interface;

import com.example.hotelbooking_app.Booking.Item.BookingPaymentMethod;

public interface PaymentSelectionListener {
    void onPaymentSelected(BookingPaymentMethod paymentData);
}
