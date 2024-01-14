/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BIMA200923;

/**
 *
 * @author Lenovo
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimatedBannerApp extends JFrame {
    private JLabel bannerLabel;
    private String bannerText;
    private int xPos = 0;
    private Color[] textColors = {Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE};
    private Color backgroundColor = Color.BLACK;

    public AnimatedBannerApp() {
        setTitle("Animated Banner App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 165);
        setLayout(null);

        bannerText = JOptionPane.showInputDialog("Masukkan teks untuk banner:");
        bannerLabel = new JLabel(bannerText);
        bannerLabel.setFont(new Font("Arial", Font.PLAIN, 36));
        bannerLabel.setForeground(textColors[0]); 
        bannerLabel.setBounds(0, 0, 400, 100);
        add(bannerLabel);

        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveBanner();
            }
        });

        timer.start();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void moveBanner() {
        int labelWidth = bannerLabel.getPreferredSize().width;
        int windowWidth = getWidth();

        if (xPos + labelWidth > windowWidth) {
            xPos = -labelWidth;
            int randomColorIndex = (int) (Math.random() * textColors.length);
            bannerLabel.setForeground(textColors[randomColorIndex]);
        }

        bannerLabel.setLocation(xPos, 0);
        xPos += 5; 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AnimatedBannerApp();
            }
        });
    }
}

