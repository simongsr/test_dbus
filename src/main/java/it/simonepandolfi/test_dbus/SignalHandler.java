package it.simonepandolfi.test_dbus;

import org.freedesktop.dbus.interfaces.DBusSigHandler;

public class SignalHandler implements DBusSigHandler<Signal.MySignal> {

    @Override
    public void handle(Signal.MySignal mySignal) {
        System.out.println("SIGNAL");
    }
}
