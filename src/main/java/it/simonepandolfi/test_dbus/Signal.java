package it.simonepandolfi.test_dbus;

import org.freedesktop.dbus.exceptions.DBusException;
import org.freedesktop.dbus.interfaces.DBusInterface;
import org.freedesktop.dbus.messages.DBusSignal;

public interface Signal extends DBusInterface {

    class MySignal extends DBusSignal {

        public MySignal(String source, String path, String iface, String member, String sig, Object... args) throws DBusException {
            super(source, path, iface, member, sig, args);
        }

        protected MySignal(String objectpath, Object... args) throws DBusException {
            super(objectpath, args);
        }
    }
}
