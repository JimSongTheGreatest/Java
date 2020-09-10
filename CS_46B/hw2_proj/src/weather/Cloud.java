package weather;

public class Cloud {

	private float bottom,top;
	
	public Cloud(float bottomIndicator, float topIndicator){
		this.bottom = bottomIndicator;
		this.top = topIndicator;
		
	}
	
	public float getHeight() {
		float height;
		height = top - bottom;
		return height;
	}
	
	public String rain() {
		String raining = "It is raining";
		return raining;
	}
	
	
	

}
