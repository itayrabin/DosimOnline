package org.dosimonline.states;

import java.awt.Font;

import it.randomtower.engine.World;
import org.dosimonline.Button;
import org.dosimonline.DosimOnline;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

public class About extends World {
	private Button backButton;
	private Image hakotel;
	private TrueTypeFont titleFont, font;

	public About(int id, GameContainer gc) throws SlickException {
		super(id, gc);

		backButton = new Button(40, DosimOnline.dm.getHeight() - 40, "Back");
		hakotel = new Image("org/dosimonline/res/hakotel.png").getScaledCopy(
				DosimOnline.dm.getWidth(), DosimOnline.dm.getHeight());

		titleFont = new TrueTypeFont(
				new Font("Arial", Font.BOLD, 56), true);

		font = new TrueTypeFont(new Font("Source Sans Pro", Font.PLAIN, 32),
				true);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		super.update(gc, sbg, delta);

		backButton.update(gc.getInput());

		if (backButton.activated()
				|| gc.getInput().isKeyPressed(Input.KEY_ESCAPE))
			sbg.enterState(1);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		super.render(gc, sbg, g);

		g.drawImage(hakotel, 0, 0);

		Play.drawCenteredString(titleFont, "Dosim Online "
				+ DosimOnline.version, DosimOnline.dm.getWidth() / 2, DosimOnline.dm.getHeight() / 2 - 250,
				Color.black);
		
		Play.drawCenteredString(font,
				"Programming: Shpitzick, Itay Rabin, yashax, Gilnaa",
				DosimOnline.dm.getWidth() / 2, DosimOnline.dm.getHeight() / 2 - 130, Color.black);

		Play.drawCenteredString(font,
				"Graphics: Tomer Ginzburg, Yinon-David Zadok",
				DosimOnline.dm.getWidth() / 2, DosimOnline.dm.getHeight() / 2 - 80, Color.black);
		Play.drawCenteredString(font, "Site Management: royysszz, Solainz",
				gc.getWidth() / 2, DosimOnline.dm.getHeight() / 2 - 30, Color.black);
		Play.drawCenteredString(font,
				"Testers: Michael Puniansky, Martin Korotkov, Oquda",
				DosimOnline.dm.getWidth() / 2, DosimOnline.dm.getHeight() / 2 + 20, Color.black);
		Play.drawCenteredString(font,
				"Music: Makche (Alleviation is played at the background)",
				DosimOnline.dm.getWidth() / 2, DosimOnline.dm.getHeight() / 2 + 70, Color.black);

		backButton.render(g);
	}
}
