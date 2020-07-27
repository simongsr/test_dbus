package it.simonepandolfi.test_dbus;

import org.freedesktop.dbus.exceptions.DBusException;
import org.freedesktop.dbus.interfaces.DBusInterface;
import org.freedesktop.dbus.messages.DBusSignal;

public interface Signal extends DBusInterface {

    class MySignal extends DBusSignal {

        private final String message;

        public MySignal(String path, String message) throws DBusException {
            super(path, message);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
