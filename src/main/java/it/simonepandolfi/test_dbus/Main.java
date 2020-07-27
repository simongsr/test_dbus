package it.simonepandolfi.test_dbus;

import org.freedesktop.dbus.DBusMatchRule;
import org.freedesktop.dbus.connections.impl.DBusConnection;
import org.freedesktop.dbus.exceptions.DBusException;
import org.freedesktop.dbus.messages.DBusSignal;

public class Main {

    public static final String BUS_NAME = "it.simonepandolfi.test_dbus";
    public static final String OBJECT_PATH = "/it/simonepandolfi/test_dbus";
    public static final String OBJECT_PATH_EMITTER = "/it/simonepandolfi/emitter";

    public static void main(String[] args) throws DBusException, InterruptedException {
        DBusConnection connection = DBusConnection.getConnection(DBusConnection.DBusBusType.SESSION);
        System.out.println(connection.getAddress());
        System.out.println(connection.getUniqueName());
        try {
            if (args.length > 0 && "server".equalsIgnoreCase(args[0])) {
                System.out.println("Starting server...");
                try {
                    connection.requestBusName(BUS_NAME);
                } catch (DBusException e) {
//                    e.printStackTrace();
                }

                MyInterface myInterface = new MyObject();
                connection.exportObject(OBJECT_PATH, myInterface);

                connection.addSigHandler(Signal.MySignal.class, new SignalHandler());
                Thread.sleep(10000L);
            } else {
                System.out.println("Starting client...");

//                MyInterface myInterface = connection.getRemoteObject(BUS_NAME, OBJECT_PATH, MyInterface.class);
//                System.out.println(myInterface.greet("Simon"));

//                connection.sendMessage(new Signal.MySignal(
//                        connection.getUniqueName(),
//                        OBJECT_PATH_EMITTER,
//                        "it.simonepandolfi.test_dbus.Signal",
//                        "MySignal",
//                        "",
//                        "CIAO"
//                ));

//                connection.sendMessage(new Signal.MySignal(OBJECT_PATH_EMITTER));

//                DBusSignal signal = new Signal.MySignal(
//                        connection.getUniqueName(),
//                        OBJECT_PATH_EMITTER,
//                        "it.simonepandolfi.test_dbus.Signal",
//                        "MySignal",
//                        ""
//                ).createReal(connection);

//                DBusSignal signal = new Signal.MySignal(OBJECT_PATH_EMITTER).createReal(connection);
//                connection.sendMessage(signal);
                connection.sendMessage(new Signal.MySignal(OBJECT_PATH, "hello, world!"));
            }
        } finally {
//            connection.close();
        }
    }
}
