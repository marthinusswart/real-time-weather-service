package com.mattswart.realtimeweatherservice.dto;

/**
 * Represents the status of the Real-Time Weather Service.
 * <p>
 * Contains a status string and an optional message.
 * </p>
 *
 * @param status  the status of the service (e.g., "OK", "ERROR")
 * @param message a descriptive message about the service status
 */
public record RTWStatus(String status, String message) {
    /**
     * Constructs an RTWStatus with the given status and a default message.
     *
     * @param status the status of the service
     */
    public RTWStatus(String status) {
        this(status, "Service is operational");
    }

    /**
     * Constructs an RTWStatus with default status "OK" and default message.
     */
    public RTWStatus() {
        this("OK", "Service is operational");
    }
}