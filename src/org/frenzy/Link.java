package org.frenzy;

/**
 * Created by artem.grechishnikov on 02.06.2015.
 */
public abstract class Link {
    private String from;
    private String to;

    private int quantityOfTasks; // Measured in man-hour

    protected void setDeparture (String isGoingFrom) {
        from = isGoingFrom;
    }

    protected String getDeparture () {
        return from;
    }

    protected void setDestination (String isGoingTo) {
        to = isGoingTo;
    }

    protected String getDestination () {
        return to;
    }

    protected void setQuantityOfTasks (int quantity) {
        quantityOfTasks = quantity;
    }

    protected int getQuantityOfTasks () {
        return quantityOfTasks;
    }
}
