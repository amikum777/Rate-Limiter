package ratelimit;

public class HandleRequest {

	public BucketLimit blimit;

	
	public void handleRequest(int maxRequestPerSec) {
		//create Bucket limit as per number of requests
		blimit = new BucketLimit(maxRequestPerSec);
		int count=1;
		
		// calling bucket limit allow method to check the request time stamp
		while(blimit.allow()) {
			// if request reaches to limit as per number of request pass print error
			if(count <= maxRequestPerSec) {
				System.out.println(count  +" Request Processed: " + blimit.allow());
			}else {
				System.out.println(count  +" Request failed due to limit to: " + maxRequestPerSec);
				break;
			}
			count++;
		}

	}

	public static void main(String[] str) {
		HandleRequest numberOfRequests = new HandleRequest();
		numberOfRequests.handleRequest(10);

	}

}
