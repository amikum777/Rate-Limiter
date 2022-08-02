package ratelimit;

import java.util.HashMap;
import java.util.Map;

final public class WindowKey {
	
	public static Map<String,Integer> window = new HashMap<>();
	
	WindowKey(Map<String,Integer> requestwindow){
		window = requestwindow;
	}

	public static Map<String, Integer> getWindow() {
		return window;
	}
	

}
