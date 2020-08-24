import java.awt.*;
import java.awt.event.*;

public  class BlackandWhiteFilter implements Filter{
	 public void filter(PixelImage pi) {
		 
		blackandwhite(pi);	 
	 }
	 
	 private void blackandwhite(PixelImage pi){
			
		 Pixel[][] data = pi.getData();
	 	 Pixel[][] dataUpdate = pi.getData();
	 	 for (int i = 1; i <pi.getHeight()-1; i++) {
			 for (int j = 1; j <pi.getWidth()-1; j++) {
				 dataUpdate[i][j].red=(int)(0.21*data[i][j].red+0.08*data[i][j].blue+0.71*data[i][j].green);
				 dataUpdate[i][j].blue= dataUpdate[i][j].red;
				 dataUpdate[i][j].green= dataUpdate[i][j].red;
		        
		    }
		}
		
	 	pi.setData(dataUpdate);
	}
	
}