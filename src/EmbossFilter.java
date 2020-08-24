
public class EmbossFilter implements Filter{
	 public void filter(PixelImage pi) 
	 {
		 // call the private function to modify the pixel's data
	   	    embossTransform(pi);
	 }
	 
	 
	 private void embossTransform(PixelImage pi) {
			
			Pixel[][] data = pi.getData();
			Pixel[][] dataUpdate = pi.getData();
			int height = pi.getHeight();
			int width = pi.getWidth();
			
			for (int i = 1; i < height-1; i++) {
				 for (int j = 1; j < width-1; j++) {
					 int upperLeft = 0;
				     int lowerRight = 0;
				     if (i > 0 && j > 0)
				        	upperLeft= data[i-1][j-1].red+data[i-1][j-1].blue+data[i-1][j-1].green;
				     if (i < height - 1 && j < width - 1)
				            lowerRight= data[i+1][j+1].red+data[i+1][j+1].blue+data[i+1][j+1].green;
				     
			          dataUpdate[i][j].red = ((lowerRight >> 16) & 255) - ((upperLeft >> 16) & 255);
			          dataUpdate[i][j].green= ((lowerRight >> 8) & 255) - ((upperLeft >> 8) & 255);
			          dataUpdate[i][j].blue = (lowerRight & 255) - (upperLeft & 255);

			          int diff = dataUpdate[i][j].red ;
			          if (Math.abs(dataUpdate[i][j].green) > Math.abs(diff))
			            diff = dataUpdate[i][j].green;
			          if (Math.abs(dataUpdate[i][j].blue) > Math.abs(diff))
			            diff = dataUpdate[i][j].blue;

			          int grayColor = 128 + diff;

			          if (grayColor > 255)
			            grayColor = 255;
			          else if (grayColor < 0)
			            grayColor = 0;
			          	
			          grayColor =Math.max(Math.min(grayColor, 255), 0) ;
			          dataUpdate[i][j].green= grayColor ;
			          dataUpdate[i][j].blue= grayColor  ;
			          dataUpdate[i][j].red=grayColor ;

				    
			    }
			}
			
			 pi.setData(dataUpdate);
			

		  }

}