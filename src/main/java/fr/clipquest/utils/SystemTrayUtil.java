package fr.clipquest.utils;

import fr.clipquest.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class SystemTrayUtil {

    private static final String ICON_PATH = "/fr/clipquest/assets/images/";
    private static boolean menuOpen = false;

    public static void initSystemTray(String title, String icon) {
        if (SystemTray.isSupported()) {
            Image image = Toolkit.getDefaultToolkit().getImage(Objects.requireNonNull(SystemTrayUtil.class.getResource(ICON_PATH + icon)));
            TrayIcon trayIcon = new TrayIcon(image, title);
            trayIcon.setImageAutoSize(true);

            SystemTray tray = SystemTray.getSystemTray();

            try {
                tray.add(trayIcon);
                trayIcon.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON1) {

                        } else if (e.getButton() == MouseEvent.BUTTON3) {

                        }
                    }
                });
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }

}
