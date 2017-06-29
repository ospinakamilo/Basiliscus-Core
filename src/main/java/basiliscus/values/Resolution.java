/**
 * 
 * @author Camilo A. Ospina A.
 * 
 */
package basiliscus.values;


/**
 * List of accepted browser resolutions
 */
public enum Resolution {
	DESKTOP_LARGE(1500, 700), //DESKTOP_LARGE(width, height)
	DESKTOP_MEDIUM(1024, 700),
	TABLET(827, 700),
	MOBILE(320, 700);
	
	private final Integer width;
	private final Integer height;
	
	private Resolution(Integer width, Integer height){
		this.width=width;
		this.height=height;		
	}
	
	
	/**
	 * Find out Resolution Width.
	 * @return Current Resolution width.
	 */
	public Integer getWidth(){
		return this.width;
	}
	
	/**
	 * Find out Resolution Height.
	 * @return Current Resolution height.
	 */
	public Integer getHeight(){
		return this.height;
	}

}
