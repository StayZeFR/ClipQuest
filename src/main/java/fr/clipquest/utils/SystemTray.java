package fr.clipquest.utils;

import fr.clipquest.Window;
import javafx.application.Platform;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class SystemTray {

    private static final String ICON_PATH = "/fr/clipquest/assets/images/";

    public static void initSystemTray(String title, String icon) {
        if (java.awt.SystemTray.isSupported()) {
            Image image = Toolkit.getDefaultToolkit().getImage(Objects.requireNonNull(SystemTray.class.getResource(ICON_PATH + icon)));
            TrayIcon trayIcon = new TrayIcon(image, title);
            trayIcon.setImageAutoSize(true);

            java.awt.SystemTray tray = java.awt.SystemTray.getSystemTray();

            try {
                tray.add(trayIcon);
                trayIcon.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            Platform.runLater(() -> {
                                if (Window.getMain().isIconified()) {
                                    Window.getMain().setIconified(false);
                                } else {
                                    Window.getMain().show();
                                }
                                Window.getMain().toFront();
                            });
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
