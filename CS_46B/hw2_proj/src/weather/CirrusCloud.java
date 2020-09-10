package weather;

public class CirrusCloud extends Cloud{

	public CirrusCloud(float bottomIndicator, float topIndicator) {
		super(bottomIndicator, topIndicator);
		// TODO Auto-generated constructor stub
	}
	
	public String rain(){
		super.rain();
		String notRaining = "I cannot make rain";
		return notRaining;
		
	}
}
