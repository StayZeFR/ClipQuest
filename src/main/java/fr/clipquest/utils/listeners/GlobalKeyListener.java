package fr.clipquest.utils.listeners;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import fr.clipquest.Config;
import fr.clipquest.Window;
import fr.clipquest.utils.session.Session;
import javafx.application.Platform;
import org.bytedeco.javacv.FrameRecorder;

public class GlobalKeyListener implements NativeKeyListener {

    private boolean altPressed = false;

    public void nativeKeyPressed(NativeKeyEvent e) {
        if (e.getKeyCode() == NativeKeyEvent.VC_ALT) {
            altPressed = true;
        } else if (altPressed && e.getKeyCode() == NativeKeyEvent.VC_F10) {
            Platform.runLater(() -> {
                Window.getMain().show();
                if (Window.getMain().isIconified()) {
                    Window.getMain().setIconified(false);
                }
                Window.getMain().toFront();
            });
        } else if (altPressed && e.getKeyCode() == NativeKeyEvent.VC_F9) {
            try {
                Session.getInstance().getRecorder().clip(10, Config.CONFIG_PATH.getValue() + "clip.mp4");
                System.out.println("Clip saved");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        if (e.getKeyCode() == NativeKeyEvent.VC_ALT) {
            altPressed = false;
        }
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
    }

}
