package com.mftvanak.classes.jee.zero.encoding;

public interface Serializer<T> {

	byte[] serialize(T object);

	T deserialize(byte[] objectData);

}
