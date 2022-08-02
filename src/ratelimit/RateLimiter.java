package ratelimit;

public abstract class RateLimiter {
	final int maxRequestPerSec;
	RateLimiter(int maxRequestPerSec){
		this.maxRequestPerSec = maxRequestPerSec;
	}
	
	abstract boolean allow();
}
