package it.simonepandolfi.test_dbus;

public class MyObject implements MyInterface {
    public String greet(String name) {
        System.out.println("Greeting!");
        return String.format("Hello %s!", name);
    }

    public boolean isRemote() {
        return false;
    }

    public String getObjectPath() {
        return Main.OBJECT_PATH;
    }
}
