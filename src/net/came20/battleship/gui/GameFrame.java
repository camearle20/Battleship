package net.came20.battleship.gui;

import net.came20.battleship.board.Board;
import net.came20.battleship.board.BoardSpace;
import net.came20.battleship.board.SpaceOwner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel mainPanel;

    public GameFrame() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public static void init(Board board) {
        int rows = board.getNumRows();
        int cols = board.getNumCols();
        GameFrame dialog = new GameFrame();
        JPanel parentPanel = new JPanel(new GridLayout(rows, cols));
        dialog.mainPanel.add(parentPanel);
        BoardSpace[][] boardArray = board.getBoardArray(SpaceOwner.PLAYER);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                boardArray[row][col].getAssocLabel().setIcon(new ImageIcon(GameFrame.class.getResource("/res/NONE_DEBUG.png")));
                parentPanel.add(boardArray[row][col].getAssocLabel());
            }
        }
        dialog.pack();
        dialog.setVisible(true);
    }
}
