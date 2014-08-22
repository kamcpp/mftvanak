package com.mftvanak.classes.jee.zero.encoding;

public class EncoderFactory {

	public static Encoder createEncoder() {
		return new Base64Encoder();
	}
}
