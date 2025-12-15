package com.example.Notification.Service._7.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingEvent {
    private Long bookingId;
    private Long vehicleId;
    private String vehicleName;
    private String carLicensePlate;
    private Long ownerId;
    private Long renterId;
    private String renterName;
    private String renterPhone;
    private String startDate;
    private String endDate;
    private Long totalPrice;
    private String occurredOn;
}
