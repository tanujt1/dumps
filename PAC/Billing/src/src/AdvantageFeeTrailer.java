package src;

import com.github.ffpojo.metadata.positional.annotation.PositionalField;
import com.github.ffpojo.metadata.positional.annotation.PositionalRecord;

@PositionalRecord
public class AdvantageFeeTrailer {
	private String caption;
	
	@PositionalField(initialPosition=1, finalPosition=16)
	public String getCaption(){
		return caption;
	}
	
	public void setCaption(String newCaption){
		this.caption = newCaption;
	}
}
