package com.navroopsingh;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event {
    protected String eventTitle;
    protected String eventNotes;
    protected LocalDateTime eventDateTime;


    /*
     * Constructor for Event expects eventDateAndTime to be of format
     * "MM/dd/yyyy HH:mm". This is strictly enforced for consistency.
     */
    Event(String eventTitle, String eventDateAndTime, String eventNotes) {
        this.eventTitle = eventTitle;
        this.eventNotes = eventNotes;

        DateTimeFormatter eventDateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        try {
            this.eventDateTime = this.eventDateTime.parse(eventDateAndTime, eventDateTimeFormatter);
        } catch (DateTimeParseException e) {
            System.out.println(e);
        }
    }

    public String getEventTitle() {
        return this.eventTitle;
    }

    public String getEventNotes() {
        return this.eventNotes;
    }

    public LocalDateTime getEventDateTime() {
        return this.eventDateTime;
    }

    @Override
    public String toString() {
        int numCharactersBetweenPipes = 20;
        int lengthOfEventTitle = this.getEventTitle().length();
        DateTimeFormatter eventDateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy @ h:mma");
        return this.eventDateTime.format(eventDateFormatter) + " | " +
                this.getEventTitle() +
                this.createEmptyString(numCharactersBetweenPipes - lengthOfEventTitle) +
                " | Notes: " + this.getEventNotes();
    }

    /*
     * Method that creates an empty string count characters long.
     * Used for padding output.
     */
    private static String createEmptyString(int count) {
        return new String(new char[count]).replace("\0", " ");
    }
}