
public class EdgyFilter implements Filter{
	 public void filter(PixelImage pi) {
	   	 int[][] weights = {{-1,-1,-1},{-1,9,-1},{-1,-1,-1}};
	   	 // call the private function transformImage to modify the pixel's data regarding the metrix's value
	   	 // @para: PixelImage pi, int[][] weights
	   	edgyTransform(pi, weights);
	    }
	 
	 private void edgyTransform(PixelImage pi, int[][] weights) {
	 	 Pixel[][] data = pi.getData();
	 	 Pixel[][] dataUpdate = pi.getData(); // this way dataUpdate
	 	 // has automatically the same size as data
	 	 
	 	 // loop to create the new pixels. Put the new pixels in dataUpdate
	 	 
	 	int height = pi.getHeight();
		int width = pi.getWidth();
	 	
	 	 for (int i = 0; i < height-2; i++) {
	 		 for (int j = 0; j < width-2; j++) {
	 			dataUpdate[i][j].red=0;
	 			dataUpdate[i][j].blue=0;
	 			dataUpdate[i][j].green=0;
	 		    //Loop to get dataUpdate[i][j].red = weights[0][0]*data[i-1][j-1].red ...
		 		 for(int ii=0; ii<3; ii++){ 
		 			  for(int kk= 0; kk<3; kk++){
		 				  dataUpdate[i][j].red +=weights[ii][kk]*data[i+ii][j+kk].red;
		 				  dataUpdate[i][j].blue +=weights[ii][kk]*data[i+ii][j+kk].blue;
		 				  dataUpdate[i][j].green +=weights[ii][kk]*data[i+ii][j+kk].green; 
		 			  }
		 		}//end loop to get dataUpdate[i][j].red,dataUpdate[i][j].blue,dataUpdate[i][j].green	
	 				
 				dataUpdate[i][j].red =Math.max(Math.min((dataUpdate[i][j]).red, 255), 0) ;
 				
 				dataUpdate[i][j].green =Math.max(Math.min((dataUpdate[i][j]).green, 255), 0) ;
 				
 				dataUpdate[i][j].blue =Math.max(Math.min((dataUpdate[i][j]).blue, 255), 0) ;
	 			
	 			 
	 		 }//end width j loop : dataUpdate[i][j].red,dataUpdate[i][j].blue, dataUpdate[i][j].green	
	 	 }// end loop to get dataUpdate;
	 	 // update the PiexlImage's data
	 	 pi.setData(dataUpdate);
	  }// end transformImage method

}
