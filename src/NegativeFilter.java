
	public  class NegativeFilter  implements Filter{
		 public void filter(PixelImage pi) 
		 {
			// call the private function to modify the pixel's data
			 negativeTransform(pi);
			 
		 }
		 
		 private void negativeTransform(PixelImage pi){
				
			 Pixel[][] data = pi.getData();
		 	 Pixel[][] dataUpdate = pi.getData();
		 	for (int i = 0; i < pi.getHeight(); i++) {
				 for (int j = 0; j < pi.getWidth(); j++) {
					 dataUpdate[i][j].red=255-data[i][j].red;
					 dataUpdate[i][j].blue=255- dataUpdate[i][j].blue;
					 dataUpdate[i][j].green=255- dataUpdate[i][j].green;
			        //set new pixel
			    }
			}
			
		 	pi.setData(dataUpdate);
		}
		
	}
		

