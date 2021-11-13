module security {
    requires image;
    requires miglayout;
    requires java.desktop;
    requires com.google.common;
    requires java.prefs;
    requires com.google.gson;
    requires org.slf4j;
    requires software.amazon.awssdk.auth;
    requires software.amazon.awssdk.core;
    requires software.amazon.awssdk.regions;
    requires software.amazon.awssdk.services.rekognition;

    opens data to com.google.gson;
}