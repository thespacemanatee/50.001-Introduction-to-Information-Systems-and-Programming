

// Todo: StockGrabber implements Subject, keeps track of the list of subscribers, notifies them any change in stock prices
 
public class StockGrabber {
	private double ibmPrice;
	private double googPrice;
	
	public void setIbmPrice(double ibmPrice){
		this.ibmPrice= ibmPrice;
	}

	public void setGoogPrice(double googPrice){
		this.googPrice= googPrice;
	}
}
