/**
 * Filter that flips the image vertically.
 */
public class FlipVerticalFilter implements Filter {
	// over write the filter function
	public void filter(PixelImage pi) {
		// get original pixels' data value.
		Pixel[][] data = pi.getData();

		for (int row = 0; row < pi.getHeight() / 2; row++) {
			for (int col = 0; col < pi.getWidth(); col++) {
				Pixel temp = data[row][col];
				data[row][col] = data[pi.getHeight() - row - 1][col];
				data[pi.getHeight() - row - 1][col] = temp;
			}
		}

		pi.setData(data);
	}
}