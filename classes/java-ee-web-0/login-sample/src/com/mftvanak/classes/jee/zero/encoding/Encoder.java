package com.mftvanak.classes.jee.zero.encoding;

public interface Encoder {

	String encode(byte[] toEncode);

	byte[] decode(String toDecode);

}
