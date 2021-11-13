package application;

import data.PretendDatabaseSecurityRepositoryImpl;
import data.SecurityRepository;
import imageService.FakeImageService;
import net.miginfocom.swing.MigLayout;
import service.SecurityService;

import javax.swing.*;

/**
 * This is the primary JFrame for the application that contains all the top-level JPanels.
 *
 * We're not using any dependency injection framework, so this class also handles constructing
 * all our dependencies and providing them to other classes as necessary.
 */
public class CatpointGui extends JFrame {
    public final SecurityRepository securityRepository = new PretendDatabaseSecurityRepositoryImpl();
    public final FakeImageService imageService = new FakeImageService();
    public final SecurityService securityService = new SecurityService(securityRepository, imageService);

    public final DisplayPanel displayPanel = new DisplayPanel(securityService);
    public final ControlPanel controlPanel = new ControlPanel(securityService);
    public final SensorPanel sensorPanel = new SensorPanel(securityService);
    public final ImagePanel imagePanel = new ImagePanel(securityService);

    public CatpointGui() {
        setLocation(100, 100);
        setSize(600, 850);
        setTitle("Very Secure App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new MigLayout());
        DisplayPanel displayPanel = new DisplayPanel(securityService);
        mainPanel.add(displayPanel, "wrap");
        application.ImagePanel imagePanel = new application.ImagePanel(securityService);
        mainPanel.add(imagePanel, "wrap");
        ControlPanel controlPanel = new ControlPanel(securityService);
        mainPanel.add(controlPanel, "wrap");
        SensorPanel sensorPanel = new SensorPanel(securityService);
        mainPanel.add(sensorPanel);

        getContentPane().add(mainPanel);

    }
}