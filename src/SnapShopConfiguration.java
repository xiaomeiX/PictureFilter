// Write your short report here (-2 if there is no report)
/**
 * 1) FlipHorizontalFilter: Completed, don't need change
 * 2) FlipVerticalFilter:  implement Filter and overwrite the filter funtion.
 *     get the original data from the image, by call
 *               Pixel[][] data = pi.getData();
 *     use for loop 2D Pixel array to modify the pixels data and reset each pixels's value
 *              Pixel temp = data[row][col];
 *				data[row][col] = data[pi.getHeight() - row - 1][col];
 *				data[pi.getHeight() - row - 1][col] = temp;
 *     pi.setData(data);
 * 3) NegativeFilter : implement Filter and overwrite the filter funtion.
 *    In filter function:
 *     call the private function to modify the pixel's data
 *			 negativeTransform(pi);  
 *           @ para: Pixel pi
 *     use for loop 2D Pixel array to modify the pixels rgb's data and reset each pixels's value     
 *            dataUpdate[i][j].red=255-data[i][j].red;
 *			  dataUpdate[i][j].blue=255- dataUpdate[i][j].blue;
 *			  dataUpdate[i][j].green=255- dataUpdate[i][j].green;
 *    
 *     set the pixel's data with new values
 *            pi.setData(dataUpdate); 
 *   -----------------------------------
 * 4) GaussianFilter: implement Filter and overwrite the filter function.
 *    In filter function:
 *     ##  define the weights of the matrix.
 *     	     int[][] weights = {{1,2,1},{2,4,2},{1,2,1}};
 *     ##  call the private function to modify the pixel's data       
 *			 gaussionTransform(pi, weights);  
 *           @ para: Pixel pi, int[][] weights
 *     use for loop 2D Pixel array to modify the pixels data and reset each pixels's value   
 *     ##  for loop the weights metrix and modify each pixel's value by multify the weights's metrix's data
 *           dataUpdate[i][j].red += weights[ii][kk]*data[i+ii][j+kk].red;
 *			 dataUpdate[i][j].blue += weights[ii][kk]*data[i+ii][j+kk].blue;
 *			 dataUpdate[i][j].green += weights[ii][kk]*data[i+ii][j+kk].green;
 *     ##  Graussian Filter should rgb's value divided by 16
 *           dataUpdate[i][j].red /=16;
 *			 dataUpdate[i][j].blue /=16;
 *			 dataUpdate[i][j].green /=16;	   
 *           
 *     set the pixel's data with updated values
 *            pi.setData(dataUpdate); 
 *   -----------------------------------------                    
 * 5) LaplacianFilter: implement Filter and overwrite the filter function.
 *    In filter function:
 *     ##  define the weights of the matrix.
 *     	     int[][] weights = {{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};
 *     ##  call the private function to modify the pixel's data       
 *			 laplacianTransform(pi, weights);  
 *           @ para: Pixel pi, int[][] weights
 *     use for loop 2D Pixel array to modify the pixels data and reset each pixels's value   
 *     ##  for loop 2D the weights array and modify each pixel's value by multify the weights's metrix's data
 *           dataUpdate[i][j].red += weights[ii][kk]*data[i+ii][j+kk].red;
 *			 dataUpdate[i][j].blue += weights[ii][kk]*data[i+ii][j+kk].blue;
 *			 dataUpdate[i][j].green += weights[ii][kk]*data[i+ii][j+kk].green;
 *     ##  Laplacian Filter should rgb's value update each pixels rgb by Math.max(Math.min(*.red, 255),0)
 *           dataUpdate[i][j].red =Math.max(Math.min((dataUpdate[i][j]).red, 255), 0) ;				
 *			 dataUpdate[i][j].green =Math.max(Math.min((dataUpdate[i][j]).green, 255), 0) ;				
 *			 dataUpdate[i][j].blue =Math.max(Math.min((dataUpdate[i][j]).blue, 255), 0) ;	   
 *           
 *     set the pixel's data with updated values
 *            pi.setData(dataUpdate); 
 *   ----------------------------------------- 
 * 6) UnsharpFilter: implement Filter and overwrite the filter function.
 *    In filter function:
 *     ##  define the weights of the matrix.
 *     	     int[][] weights = {{-1,-2,-1},{-2,28,-2},{-1,-2,-1}};
 *     ##  call the private function to modify the pixel's data       
 *			 unsharpTransform(pi, weights);  
 *           @ para: Pixel pi, int[][] weights
 *     use for loop 2D Pixel array to modify the pixels data and reset each pixels's value   
 *     ##  for loop 2D the weights array and modify each pixel's value by multify the weights's metrix's data
 *           dataUpdate[i][j].red += weights[ii][kk]*data[i+ii][j+kk].red;
 *			 dataUpdate[i][j].blue += weights[ii][kk]*data[i+ii][j+kk].blue;
 *			 dataUpdate[i][j].green += weights[ii][kk]*data[i+ii][j+kk].green;
 *     a. like Graussian update each pixels' rgb value divided by 16
 *              dataUpdate[i][j].red /=16;
 *			    dataUpdate[i][j].blue /=16;
 *			    dataUpdate[i][j].green /=16;
 *	    b. like Laplacian Filter should rgb's value update each pixels rgb by Math.max(Math.min(*.red, 255),0)    
 *           dataUpdate[i][j].red =Math.max(Math.min((dataUpdate[i][j]).red, 255), 0) ;				
 *			 dataUpdate[i][j].green =Math.max(Math.min((dataUpdate[i][j]).green, 255), 0) ;				
 *			 dataUpdate[i][j].blue =Math.max(Math.min((dataUpdate[i][j]).blue, 255), 0) ;	   
 *           
 *     set the pixel's data with updated values
 *            pi.setData(dataUpdate); 
 *   ----------------------------------------- 
 * 7) EdgyFilter: implement Filter and overwrite the filter function.
 *    In filter function:
 *     ##  define the weights of the matrix.
 *     	     int[][] weights = {{-1,-1,-1},{-1,9,-1},{-1,-1,-1}};
 *     ##  call the private function to modify the pixel's data       
 *			 edgyTransform(pi, weights);  
 *           @ para: Pixel pi, int[][] weights
 *     use for loop 2D Pixel array to modify the pixels data and reset each pixels's value   
 *     ##  for loop 2D the weights array and modify each pixel's value by multify the weights's metrix's data
 *           dataUpdate[i][j].red += weights[ii][kk]*data[i+ii][j+kk].red;
 *			 dataUpdate[i][j].blue += weights[ii][kk]*data[i+ii][j+kk].blue;
 *			 dataUpdate[i][j].green += weights[ii][kk]*data[i+ii][j+kk].green;
 *	   ##  like Laplacian Filter should rgb's value update each pixels rgb by Math.max(Math.min(*.red, 255),0)    
 *           dataUpdate[i][j].red =Math.max(Math.min((dataUpdate[i][j]).red, 255), 0) ;				
 *			 dataUpdate[i][j].green =Math.max(Math.min((dataUpdate[i][j]).green, 255), 0) ;				
 *			 dataUpdate[i][j].blue =Math.max(Math.min((dataUpdate[i][j]).blue, 255), 0) ;	   
 *           
 *     set the pixel's data with updated values
 *            pi.setData(dataUpdate); 
 *   -----------------------------------------   
 * 8) EmbossFilter: implement Filter and overwrite the filter function.
 *    In filter function:
 *     ##  call the private function to modify the pixel's data       
 *			 embossTransform(pi);  
 *           @ para: Pixel pi
 *     use for loop 2D Pixel array to modify the pixels data and reset each pixels's value   
 *     a.   get upperLeft & lowerRight value regarding rgb's data value
 *     		   upperLeft= data[i-1][j-1].red+data[i-1][j-1].blue+data[i-1][j-1].green;
 *    	 	   lowerRight= data[i+1][j+1].red+data[i+1][j+1].blue+data[i+1][j+1].green;
 *     b.   change each pixels' value by:
 *             dataUpdate[i][j].red = ((lowerRight >> 16) & 255) - ((upperLeft >> 16) & 255);
 *			   dataUpdate[i][j].green= ((lowerRight >> 8) & 255) - ((upperLeft >> 8) & 255);
 *			   dataUpdate[i][j].blue = (lowerRight & 255) - (upperLeft & 255);
 *     c.   compared pixel rgb's values and set largest rgb's value as grayColor.
 *     d.   define: grayColor = 128 + Math.max(pixel.rgb) 
 *                  grayColor =Math.max(Math.min(grayColor, 255), 0) ;  
 *	   ##   set pixel's rgb value equal to grayColor
 *					dataUpdate[i][j].green= grayColor ;
 *			        dataUpdate[i][j].blue=  grayColor ;
 *			        dataUpdate[i][j].red= grayColor; 
 *           
 *     set the pixel's data with updated values
 *            pi.setData(dataUpdate); 
 * ------------------------------------------------
 *  9) BlackandWhiteFilter: implement Filter and overwrite the filter function.
 *     In filter function:
 *      ##  call the private function to modify the pixel's data       
 *			 embossTransform(pi);  
 *           @ para: Pixel pi
 *      ##  use for loop 2D Pixel array to modify the pixels data and reset each pixels's value 
 *     
 *       		dataUpdate[i][j].red=(int)(0.21*data[i][j].red+0.08*data[i][j].blue+0.71*data[i][j].green);
 *				dataUpdate[i][j].blue= dataUpdate[i][j].red;
 *				dataUpdate[i][j].green= dataUpdate[i][j].red;
 * 
 *      set the pixel's data with updated values
 *            pi.setData(dataUpdate);  
 */
public class SnapShopConfiguration
{
  /**
   * Method to configure the SnapShop.  Call methods like addFilter
   * and setDefaultFilename here.
   * @param theShop A pointer to the application
   */
  public static void configure(SnapShop theShop)
  {  
    
	     theShop.setDefaultFilename("billg.jpg");
	   	 theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
	   	 // add your other filters below
	   	 // add the button in the program window for the navigation the different filter function.
	   	 theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");
	   	 theShop.addFilter(new NegativeFilter(), "Negative");
	   	 theShop.addFilter(new GaussianFilter(), "Flip Gaussian");
	   	 theShop.addFilter(new LaplacianFilter(), "Flip Laplacian");
	   	 theShop.addFilter(new UnsharpFilter(), "Unsharp Masking");
	   	 theShop.addFilter(new EdgyFilter(), "Edgy");
	   	 theShop.addFilter(new EmbossFilter(), "Emboss");
	   	 theShop.addFilter(new BlackandWhiteFilter(), "Black & White"); 
   	
		
  }
}
