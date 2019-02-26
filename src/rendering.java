import lia.Constants;
import lia.api.GameState;
import lia.api.UnitData;
import processing.core.PApplet;
import processing.core.PFont;

/**
 * The coordinate system is different that you may be used to. x coordinate is normal, and is measured from left to right, y coordinate however is measured from top to bottom which flips the units. That means that the point (0,0) is on the upper left corner. This program renders the game map on a 1920*1080 screen, with some space left over. The program is based on the Procesing library available for free on https://processing.org/. The library first calls settings() then setup() and then 60 times per second draw().
 * 
 * @author Gregor Kikelj
 *
 */
public class rendering extends PApplet{
	public PFont f;//Not mandatory but nice to have to be able to render data on screen
	int shift=10*176;//x coordinate of the end of the map
	static boolean gameStarted=false;//if the game is not started we shouldn't render game data as it doesn't exist
	static GameState state;//we need a pointer so we know what to draw. 
	public void settings(){
		size(1920,10*99);//we define the screen size. If your monitor doesn't support such a large resolution, try modfying the program.
	}
	public void setup(){
		f=createFont("Arial",20,true);//we create the font
	}

	public void draw(){
		if(!gameStarted){//if the game is not started don't draw anything
			return;
		}
		background(255,255,255);//white background-defined by rgb
		fill(0,0,0);//the shapes we draw will have a black interior
		for(int i=0;i<176;i++){
			for(int j=0;j<99;j++){
				if(Constants.MAP[i][j]){
					rect(10*i,10*j,10,10);//we draw the map
				}
			}
		}
		fill(255,0,0);//switch to green
		for(UnitData u:state.units) {
			ellipse(10*u.x,10*u.y,20,20);//make an ellipse for our unit
		}
		text(shift,200,"This is some text");
	}
}