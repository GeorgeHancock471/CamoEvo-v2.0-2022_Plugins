// Code automatically generated by 'Generate Cone Mapping Model' script by Jolyon Troscianko

//Model fits:
//lw 0.9812972737498306
//mw 0.9877433476971808
//sw 0.9891521168765701
//dbl 0.9892638316298272


// Generated: 2020/3/3   15:35:10


import ij.*;
import ij.plugin.filter.PlugInFilter;
import ij.process.*;

public class Cubot_Quest_Lite_Peafowl_LMS_D65_ implements PlugInFilter {

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
int w = stack.getWidth();
int h = stack.getHeight();
int dimension = w*h;

float[] lw = new float[dimension];
float[] mw = new float[dimension];
float[] sw = new float[dimension];
float[] dbl = new float[dimension];

visibleR = (float[]) stack.getPixels(1);
visibleG = (float[]) stack.getPixels(2);
visibleB = (float[]) stack.getPixels(3);

for (int i=0;i<dimension;i++) {
lw[i] = (float) (0.004596033784019402 +(visibleR[i]*0.00522402155492235)+(visibleG[i]*0.004239168987177769)+(visibleB[i]*-2.9379054979429775E-4)+(visibleR[i]*visibleG[i]*2.016699268862588E-5)+(visibleR[i]*visibleB[i]*3.92332473641582E-6)+(visibleG[i]*visibleB[i]*-2.1410402522728943E-6));
mw[i] = (float) (0.01772419284797924 +(visibleR[i]*-9.509308241937111E-4)+(visibleG[i]*0.011284189589639858)+(visibleB[i]*-0.0012979367074837482)+(visibleR[i]*visibleG[i]*1.2022531944796696E-5)+(visibleR[i]*visibleB[i]*1.3006162114701046E-5)+(visibleG[i]*visibleB[i]*-9.703072881256555E-6));
sw[i] = (float) (0.021691147226283125 +(visibleR[i]*-8.118783976356432E-4)+(visibleG[i]*0.005611451673899705)+(visibleB[i]*0.004482936552993334)+(visibleR[i]*visibleG[i]*-4.953980116905996E-6)+(visibleR[i]*visibleB[i]*-9.365215876449491E-6)+(visibleG[i]*visibleB[i]*2.4877608308913365E-5));
dbl[i] = (float) (0.013844389280679473 +(visibleR[i]*8.180995277732415E-4)+(visibleG[i]*0.00853584119741004)+(visibleB[i]*-3.5751769767608093E-4)+(visibleR[i]*visibleG[i]*1.4513305608339479E-5)+(visibleR[i]*visibleB[i]*7.269530992140934E-6)+(visibleG[i]*visibleB[i]*-3.154631498270664E-6));
IJ.showProgress((float) i/dimension);
}

ImageStack outStack = new ImageStack(w, h);
outStack.addSlice("lw", lw);
outStack.addSlice("mw", mw);
outStack.addSlice("sw", sw);
outStack.addSlice("dbl", dbl);
new ImagePlus("Output", outStack).show();

}
}