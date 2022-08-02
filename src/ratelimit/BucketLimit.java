package ratelimit;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BucketLimit extends RateLimiter{

	Queue<Long> requests = new LinkedList<>();

	private long allow_interval;
//	final long Request_Interval_Millis;

	BucketLimit(int maxRequestPerSec){
		super(maxRequestPerSec);

		allow_interval = System.currentTimeMillis();

		WindowKey.window.put(""+allow_interval, maxRequestPerSec);
//		Request_Interval_Millis = 60000 / maxRequestPerSec;

	}


	@Override
	boolean allow() {

		long currentTime = System.currentTimeMillis();
		synchronized(this) {
			for(Map.Entry<String, Integer> entry: WindowKey.window.entrySet() ) {
				String requestTimeStamp = entry.getKey();
				if(currentTime >= Long.parseLong(requestTimeStamp)) {
//					allow_interval = currentTime + Request_Interval_Millis;
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}

}
