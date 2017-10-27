package src;

import com.github.ffpojo.metadata.positional.annotation.PositionalField;
import com.github.ffpojo.metadata.positional.annotation.PositionalRecord;
@PositionalRecord
public class AdvantageFeeHeader {
	private String caption;
	private String version;	
	private String createDate;
	private String sourceChannel;	
	
	@PositionalField(initialPosition=1, finalPosition=24)
	public String getCaption(){
		return caption;
	}
	
	public void setCaption(String newCaption){
		this.caption = newCaption;
	}
	
	@PositionalField(initialPosition=25, finalPosition=30)
	public String getVersion(){
		return version;
	}
	
	public void setVersion(String newVersion){
		this.version = newVersion;
	}
	
	@PositionalField(initialPosition=31, finalPosition=40)
	public String getCreateDate(){
		return createDate;
	}
	
	public void setCreateDate(String newCreateDate){
		this.createDate = newCreateDate;
	}
	
	@PositionalField(initialPosition=41, finalPosition=50)
	public String getSourceChannel(){
		return sourceChannel;
	}
	
	public void setSourceChannel(String newSourceChannel){
		this.sourceChannel = newSourceChannel;
	}
}
