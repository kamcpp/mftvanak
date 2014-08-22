package com.mftvanak.classes.jee.zero.encoding;

import org.apache.commons.codec.binary.Base64;

public class Base64Encoder implements Encoder {

	@Override
	public String encode(byte[] toEncode) {
		byte[] encodedBytes = Base64.encodeBase64(toEncode);
		return new String(encodedBytes);
	}

	@Override
	public byte[] decode(String toDecode) {
		return Base64.decodeBase64(toDecode.getBytes());
	}
}
