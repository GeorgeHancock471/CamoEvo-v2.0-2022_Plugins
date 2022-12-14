// Code automatically generated by 'Generate Cone Mapping Model' script by Jolyon Troscianko

//Model fits:
//mw 0.9964504136327282
//sw 0.9925663686873872
//uv 0.9937661670120085


// Generated: 2022/3/28   17:23:31


import ij.*;
import ij.plugin.filter.PlugInFilter;
import ij.process.*;

public class George_Honeybee_D65_ implements PlugInFilter {

ImageStack stack;
	public int setup(String arg, ImagePlus imp) { 
	stack = imp.getStack(); 
	return DOES_32 + STACK_REQUIRED; 
	}
public void run(ImageProcessor ip) {

IJ.showStatus("Cone Mapping");
float[] visibleR;
float[] visibleG;
float[] visibleB;
float[] uvB;
float[] uvR;
int w = stack.getWidth();
int h = stack.getHeight();
int dimension = w*h;

float[] mw = new float[dimension];
float[] sw = new float[dimension];
float[] uv = new float[dimension];

visibleR = (float[]) stack.getPixels(1);
visibleG = (float[]) stack.getPixels(2);
visibleB = (float[]) stack.getPixels(3);
uvB = (float[]) stack.getPixels(4);
uvR = (float[]) stack.getPixels(5);

for (int i=0;i<dimension;i++) {
mw[i] = (float) (-0.008045342641244423 +(visibleR[i]*-4.6182729558369055E-4)+(visibleG[i]*0.008525239024855904)+(visibleB[i]*0.0016868031077187872)+(uvB[i]*0.00213607860180454)+(uvR[i]*-0.0019483323698574015)+(visibleR[i]*visibleG[i]*-1.7572441850775363E-6)+(visibleR[i]*visibleB[i]*-2.570051033142454E-6)+(visibleR[i]*uvB[i]*4.2816063354313676E-5)+(visibleR[i]*uvR[i]*-3.615330818755067E-5)+(visibleG[i]*visibleB[i]*9.481955842557935E-6)+(visibleG[i]*uvB[i]*-1.0475956401348844E-4)+(visibleG[i]*uvR[i]*6.807799069488657E-5)+(visibleB[i]*uvB[i]*-6.282926361977009E-5)+(visibleB[i]*uvR[i]*9.719130779617968E-5)+(uvB[i]*uvR[i]*-9.170220235993687E-7));
sw[i] = (float) (-0.012109870017151074 +(visibleR[i]*7.483909073741263E-4)+(visibleG[i]*-0.0035955931611998224)+(visibleB[i]*0.010420429515824644)+(uvB[i]*0.0038297808390598776)+(uvR[i]*-0.001018971434669306)+(visibleR[i]*visibleG[i]*-5.83711566461531E-6)+(visibleR[i]*visibleB[i]*6.0909944446645696E-5)+(visibleR[i]*uvB[i]*6.282383077223512E-5)+(visibleR[i]*uvR[i]*-1.197534712863268E-4)+(visibleG[i]*visibleB[i]*-3.589933690563189E-5)+(visibleG[i]*uvB[i]*-3.801331779544863E-4)+(visibleG[i]*uvR[i]*4.28598568081777E-4)+(visibleB[i]*uvB[i]*2.5948394638622006E-4)+(visibleB[i]*uvR[i]*-3.0920052648456307E-4)+(uvB[i]*uvR[i]*4.417535382272499E-5));
uv[i] = (float) (-0.01087165502166707 +(visibleR[i]*1.7191798203651144E-4)+(visibleG[i]*-4.506375696107208E-4)+(visibleB[i]*0.0017854337673048131)+(uvB[i]*0.0015485728202761812)+(uvR[i]*0.007294836698270181)+(visibleR[i]*visibleG[i]*-1.2181328864035116E-5)+(visibleR[i]*visibleB[i]*4.912432787688149E-5)+(visibleR[i]*uvB[i]*4.542882347085745E-5)+(visibleR[i]*uvR[i]*-8.523079394179979E-5)+(visibleG[i]*visibleB[i]*-2.9372668095818955E-5)+(visibleG[i]*uvB[i]*-3.018520296931738E-4)+(visibleG[i]*uvR[i]*3.3520393294519604E-4)+(visibleB[i]*uvB[i]*1.7532598310123493E-4)+(visibleB[i]*uvR[i]*-1.8585543620636025E-4)+(uvB[i]*uvR[i]*1.5113114756528748E-5));
IJ.showProgress((float) i/dimension);
}

ImageStack outStack = new ImageStack(w, h);
outStack.addSlice("mw", mw);
outStack.addSlice("sw", sw);
outStack.addSlice("uv", uv);
new ImagePlus("Output", outStack).show();

}
}
