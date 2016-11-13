package net.came20.battleship.board;

import javax.swing.*;

/**
 * Created by cameron on 11/5/16.
 */
public class BoardSpace {

    private SpaceOwner owner;
    private SpaceType type;
    private JLabel label;

    public BoardSpace(SpaceOwner owner, SpaceType type) {
        this(owner, type, new JLabel());
    }

    public BoardSpace(SpaceOwner owner, SpaceType type, JLabel label) {
        this.label = label;
        this.owner = owner;
        this.type = type;
        label.setIcon(new ImageIcon(this.getClass().getResource("/res/" + this.type.toString() + "_DEBUG.png")));
    }

    public SpaceOwner getOwner() {
        return owner;
    }

    public SpaceType getType() {
        return type;
    }

    public JLabel getAssocLabel() {
        return label;
    }

    public void setAssocLabel(JLabel label) {
        this.label = label;
    }

    public void setOwner(SpaceOwner owner) {
        this.owner = owner;
    }

    public void setType(SpaceType type) {
        label.setIcon(new ImageIcon(this.getClass().getResource("/res/" + type.toString() + "_DEBUG.png")));
        this.type = type;
    }
}
