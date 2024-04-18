package fr.clipquest.tools;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class MACAddressTool {

    public static String get() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                byte[] macAddressBytes = networkInterface.getHardwareAddress();
                if (macAddressBytes != null && macAddressBytes.length == 6) {
                    StringBuilder macAddressStringBuilder = new StringBuilder();
                    for (byte b : macAddressBytes) {
                        macAddressStringBuilder.append(String.format("%02X", b));
                        macAddressStringBuilder.append(":");
                    }
                    if (!macAddressStringBuilder.isEmpty()) {
                        macAddressStringBuilder.deleteCharAt(macAddressStringBuilder.length() - 1);
                    }
                    return macAddressStringBuilder.toString();
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }

}
