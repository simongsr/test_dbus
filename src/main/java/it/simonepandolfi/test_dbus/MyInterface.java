package it.simonepandolfi.test_dbus;

import org.freedesktop.dbus.interfaces.DBusInterface;

public interface MyInterface extends DBusInterface {

    String greet(String name);
}
