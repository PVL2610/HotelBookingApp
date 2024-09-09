package com.example.hotelbooking_app.Booking.Interface;

import com.example.hotelbooking_app.Booking.Item.BookingRoomType;

import java.util.ArrayList;

public interface OnSaveClickListener {
    void onSaveClick(int totalGuests, int totalRooms);

    void onSelectClick(ArrayList<BookingRoomType> roomTypeList);
}
