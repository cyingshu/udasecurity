module security {
    requires image;
    requires miglayout;
    requires java.desktop;
    requires com.google.common;
    requires java.prefs;
    requires com.google.gson;

    opens data to com.google.gson;
}