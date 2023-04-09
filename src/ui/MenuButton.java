package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import gamestates.Gamestate;
import javafx.scene.shape.Rectangle;
import utilz.LoadSave;
import static utilz.Constants.UI.Buttons.*;

public class MenuButton {
	
	private int xPos, yPos, rowIndex, index;
	private int xOffsetCenter = B_WIDTH_DEFAULT / 2;
	private Gamestate state;
	private BufferedImage[] imgs;
	private boolean mouseOver, mousePressed;
	private Rectangle bounds;

	public MenuButton(int xPos, int yPos, int rowIndex, Gamestate state) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.rowIndex = rowIndex;
		this.state = state;
		loadImgs();
		initBounds();
	}
	
	private void initBounds() {
		bounds = new Rectangle(xPos - xOffsetCenter, yPos, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT);
	}

	private void loadImgs() {
		imgs = new BufferedImage[3];
		BufferedImage temp = LoadSave.GetSpriteAtlas(LoadSave.MENU_BUTTONS);
		for (int i = 0; i < imgs.length; i++)
			imgs[i] = temp.getSubimage(i * B_WIDTH_DEFAULT, rowIndex * B_HEIGHT_DEFAULT, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT);
	}
	
	public void draw(Graphics g) {
		g.drawImage(imgs[index], xPos - xOffsetCenter, yPos, B_WIDTH_DEFAULT, B_HEIGHT_DEFAULT, null);
	}

	public void update() {
		index = 0;
		if (mouseOver)
			index = 1;
		if (mousePressed)
			index = 2;
	}
	
	// Getters & Setters

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
		return ;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
		return ;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
		return;
	}

	public Gamestate isState() {
		return state;
	}

	public void setState(Gamestate state) {
		this.state = state;
		return ;
	}

	public BufferedImage[] getImgs() {
		return imgs;
	}

	public void setImgs(BufferedImage[] imgs) {
		this.imgs = imgs;
		return ;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
		return ;
	}

	public boolean isMouseOver() {
		return mouseOver;
	}

	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
		return ;
	}

	public boolean isMousePressed() {
		return mousePressed;
	}

	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
		return ;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
		return ;
	}
	
}
