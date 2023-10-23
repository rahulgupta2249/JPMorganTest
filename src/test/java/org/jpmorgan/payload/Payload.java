package org.jpmorgan.payload;


public interface Payload<T> {

    public T createPayloadFromPojo();
}
