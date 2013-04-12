package org.dosimonline;
import it.randomtower.engine.World;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class WorldCredits extends World
{
    public WorldCredits (int id, GameContainer gc)
    {
        super (id, gc);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
    {
        super.update(gc, sbg, delta);
        if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {sbg.enterState(1);}        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        super.render(gc, sbg, g);
        g.setBackground(Color.black);
        g.drawString("Programming: Shptzick, Itay Rabin", 40, 40);
        g.drawString("Graphics: Tomer Ginzburg", 40, 60);
        g.drawString("Beta (Or shall I say Indev?) testers: Michael Puniansky, Martin Korotkov", 40, 80);
        g.drawString("Music: Makche (Alleviation is played at the background)", 40, 100);
    }
}
