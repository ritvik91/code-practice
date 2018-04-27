package Misc;
/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane. 
 * Each rectangle is defined by its bottom left corner and top right corner coordinates.
 * 
 * https://www.programcreek.com/2014/06/leetcode-rectangle-area-java/
 * @author Ritvik
 *
 */
public class RectOverlap {

	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
	    if(C<E||G<A )
	        return (G-E)*(H-F) + (C-A)*(D-B);
	 
	    if(D<F || H<B)
	        return (G-E)*(H-F) + (C-A)*(D-B);
	 
	    int right = Math.min(C,G);
	    int left = Math.max(A,E);
	    int top = Math.min(H,D);
	    int bottom = Math.max(F,B);
	 
	    return (G-E)*(H-F) + (C-A)*(D-B) - (right-left)*(top-bottom);
	}
	
}
