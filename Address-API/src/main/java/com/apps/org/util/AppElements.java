package com.apps.org.util;

import java.util.HashMap;
import java.util.Map;

public enum AppElements {

	DB_EXCEPTION (" DB Exception", 7001),
	ALREADY_EXISTING ("Already Existing ", 7002),
	FIELDS_MISSING ("Missing Fields : ", 4004);


	private static final Map<Integer, AppElements> BY_CODE = new HashMap<>();
	private static final Map<String, AppElements> BY_MESSAGE = new HashMap<>();

	static {
		for (AppElements ae : values()) {
			BY_MESSAGE.put(ae.message, ae);
			BY_CODE.put(ae.code, ae);
		}
	}

	public final String message;
	public final int code;

	private AppElements(String message, int code) {
		this.message = message;
		this.code = code;
	}

	public static AppElements valueOfMessage(String message) {
		return BY_MESSAGE.get(message);
	}

	public static AppElements valueOfCode(int code) {
		return BY_CODE.get(code);
	}
	
	/**
	 * Return a string representation of this status code.
	 */
	@Override
	public String toString() {
		return "Code: " + this.code + ", Message: " + this.message + ", Name: " + name();
	}

}
