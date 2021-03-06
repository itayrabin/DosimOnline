package org.dosimonline;

import org.dosimonline.states.Menu;
import org.dosimonline.states.About;
import org.dosimonline.states.Play;
import org.dosimonline.states.Settings;
import java.awt.Font;
import java.io.IOException;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class DosimOnline extends StateBasedGame {
	public static String gamename = "Dosim Online";
	public static String version = "0.7";
	public static DisplayMode dm;
	private Font awtFont;
	public static TrueTypeFont font;

	public DosimOnline(String gamename) {
		super(gamename);
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		awtFont = new Font("Times New Roman", Font.PLAIN, 26);
		font = new TrueTypeFont(awtFont, true);
		addState(new Menu(1, gc));
		addState(new Play(2, gc));
		addState(new About(3, gc));
		addState(new Settings(4, gc));
		enterState(1);
	}

	public static void main(String[] args) throws IOException, LWJGLException {
		dm = Display.getDesktopDisplayMode();
		Display.setResizable(true);

		try {
			AppGameContainer appgc = new AppGameContainer(new DosimOnline(
					gamename));
			appgc.setDisplayMode(dm.getWidth(), dm.getHeight(), true);
			appgc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
