import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.*;

public class HomebaseDefence {
    private JPanel mainPanel;
    private JButton spot0;
    private JButton spot1;
    private JButton spot2;
    private JButton spot3;
    private JButton spot4;
    private JButton spot5;
    private JButton spot6;
    private JButton spot7;
    private JButton spot8;
    private JButton spot9;
    private JButton spot20;
    private JButton spot16;
    private JButton spot12;
    private JButton spot10;
    private JButton spot11;
    private JButton spot13;
    private JButton spot14;
    private JButton spot19;
    private JButton spot24;
    private JButton spot23;
    private JButton spot18;
    private JButton spot17;
    private JButton spot22;
    private JButton spot21;
    private JButton spot15;
    private JButton startResetButton;
    private JButton S1;
    private JButton S2;
    private JButton S3;
    private JButton S4;
    private JButton S5;
    private JButton S6;
    private JButton S7;
    private JButton S8;
    private JButton S9;
    private JLabel highName;
    private JLabel highScore;
    private JLabel numDestroyed;
    private JLabel scoreNum;
    private JButton healthBar;
    private JButton exitButton;
    String[][] asteroidLoc = new String[25][2];
    ImageIcon asteroid = new ImageIcon(getClass().getResource("/Assets/Images/asteroidIMG.png"));
    ImageIcon space = new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png"));
    ImageIcon fullH = new ImageIcon(getClass().getResource("/Assets/Images/fullH.jpg"));
    ImageIcon sixH = new ImageIcon(getClass().getResource("/Assets/Images/sixH.jpg"));
    ImageIcon fiveH = new ImageIcon(getClass().getResource("/Assets/Images/fiveH.jpg"));
    ImageIcon fourH = new ImageIcon(getClass().getResource("/Assets/Images/fourH.jpg"));
    ImageIcon threeH = new ImageIcon(getClass().getResource("/Assets/Images/threeH.jpg"));
    ImageIcon twoH = new ImageIcon(getClass().getResource("/Assets/Images/twoH.jpg"));
    ImageIcon oneH = new ImageIcon(getClass().getResource("/Assets/Images/oneH.jpg"));
    ImageIcon noH = new ImageIcon(getClass().getResource("/Assets/Images/noH.jpg"));
    ImageIcon defaultIcon = new ImageIcon(getClass().getResource("/Assets/Images/defaultIcon.jpg"));
    ImageIcon chosenIcon = new ImageIcon(getClass().getResource("/Assets/Images/chosenIcon.png"));
    int numberDestroyed;
    int score;
    int highScores;
    String names;
    int numHealth;
    ArrayList<Integer> pattern = new ArrayList<>();
    ArrayList<Integer> ipattern = new ArrayList<>();
    Integer[] simonPattern;
    Integer[] inputPattern;
    int patternSize = 3;
    int round = 1;
    int max = 9;
    int min = 1;
    int delay = 1000;

    public HomebaseDefence() {
        
        simonDisable();
        startResetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startResetButton.setText("Reset");
                numberDestroyed = 0;
                numHealth = 7;
                healthBar.setIcon(fullH);
                AsteroidClear();
                NewAsteroid();
                UpdateAsteroidLoc();
                // to start with multiple
                Asteroids("wrong");
                score = 0;
                numDestroyed.setText("Destroyed: ");
                scoreNum.setText("Score: ");
                // set high score values
                HighScoreBegin();
                // initializes SimonSays component
                ipattern.clear();
                pattern.clear();
                patternSize = 3;
                round = 1;
                delay = 1000;
                simonSays();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // Simon Says input buttons
        S1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ipattern.size() < patternSize - 1) {
                    ipattern.add(1);
                    simonDisable();
                    // change icon of button to different colour
                    S1.setDisabledIcon(chosenIcon);
                    simonDisable();
                    simonEnable();
                } else if (ipattern.size() == patternSize - 1) {
                    ipattern.add(1);
                    simonDisable();
                    checkPattern();
                }
            }
        });
        S2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ipattern.size() < patternSize - 1) {
                    ipattern.add(2);
                    simonDisable();
                    // change icon of button to different colour
                    S2.setDisabledIcon(chosenIcon);
                    simonDisable();
                    simonEnable();
                } else if (ipattern.size() == patternSize - 1) {
                    ipattern.add(2);
                    simonDisable();
                    checkPattern();
                }
            }
        });
        S3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ipattern.size() < patternSize - 1) {
                    ipattern.add(3);
                    simonDisable();
                    // change icon of button to different colour
                    S3.setDisabledIcon(chosenIcon);
                    simonDisable();
                    simonEnable();
                } else if (ipattern.size() == patternSize - 1) {
                    ipattern.add(3);
                    simonDisable();
                    checkPattern();
                }
            }
        });
        S4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ipattern.size() < patternSize - 1) {
                    ipattern.add(4);
                    simonDisable();
                    // change icon of button to different colour
                    S4.setDisabledIcon(chosenIcon);
                    simonDisable();
                    simonEnable();
                } else if (ipattern.size() == patternSize - 1) {
                    ipattern.add(4);
                    simonDisable();
                    checkPattern();
                }
            }
        });
        S5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ipattern.size() < patternSize - 1) {
                    ipattern.add(5);
                    simonDisable();
                    // change icon of button to different colour
                    S5.setDisabledIcon(chosenIcon);
                    simonDisable();
                    simonEnable();
                } else if (ipattern.size() == patternSize - 1) {
                    ipattern.add(5);
                    simonDisable();
                    checkPattern();
                }
            }
        });
        S6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ipattern.size() < patternSize - 1) {
                    ipattern.add(6);
                    simonDisable();
                    // change icon of button to different colour
                    S6.setDisabledIcon(chosenIcon);
                    simonDisable();
                    simonEnable();
                } else if (ipattern.size() == patternSize - 1) {
                    ipattern.add(6);
                    simonDisable();
                    checkPattern();
                }
            }
        });
        S7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ipattern.size() < patternSize - 1) {
                    ipattern.add(7);
                    simonDisable();
                    // change icon of button to different colour
                    S7.setDisabledIcon(chosenIcon);
                    simonDisable();
                    simonEnable();
                } else if (ipattern.size() == patternSize - 1) {
                    ipattern.add(7);
                    simonDisable();
                    checkPattern();
                }
            }
        });
        S8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ipattern.size() < patternSize - 1) {
                    ipattern.add(8);
                    simonDisable();
                    // change icon of button to different colour
                    S8.setDisabledIcon(chosenIcon);
                    simonDisable();
                    simonEnable();
                } else if (ipattern.size() == patternSize - 1) {
                    ipattern.add(8);
                    simonDisable();
                    checkPattern();
                }
            }
        });
        S9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ipattern.size() < patternSize - 1) {
                    ipattern.add(9);
                    simonDisable();
                    // change icon of button to different colour
                    S9.setDisabledIcon(chosenIcon);
                    simonDisable();
                    simonEnable();
                } else if (ipattern.size() == patternSize - 1) {
                    ipattern.add(9);
                    simonDisable();
                    checkPattern();
                }
            }
        });
    }

    public void HighScore() {
        try {
            String name = "Player 1";
            String filepath = "./Assets/XML/HighScore.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);

            Node a = doc.getElementsByTagName("name").item(0);
            a.setTextContent(names);

            Node b = doc.getElementsByTagName("score").item(0);
            b.setTextContent(String.valueOf(score));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("HighScore");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    highScore.setText(eElement.getElementsByTagName("score").item(0).getTextContent());
                    highName.setText(eElement.getElementsByTagName("name").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
    }

    public void HighScoreBegin() {
        try {
            String name = "";
            String filepath = "./Assets/XML/HighScore.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("HighScore");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    highScore.setText(eElement.getElementsByTagName("score").item(0).getTextContent());
                    highName.setText(eElement.getElementsByTagName("name").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
    }

    // method to clear asteroids by setting icons to the clear space background
    public void AsteroidClear() {
        spot0.setIcon(space);
        spot1.setIcon(space);
        spot2.setIcon(space);
        spot3.setIcon(space);
        spot4.setIcon(space);
        spot5.setIcon(space);
        spot6.setIcon(space);
        spot7.setIcon(space);
        spot8.setIcon(space);
        spot9.setIcon(space);
        spot10.setIcon(space);
        spot11.setIcon(space);
        spot12.setIcon(space);
        spot13.setIcon(space);
        spot14.setIcon(space);
        spot15.setIcon(space);
        spot16.setIcon(space);
        spot17.setIcon(space);
        spot18.setIcon(space);
        spot19.setIcon(space);
        spot20.setIcon(space);
        spot21.setIcon(space);
        spot22.setIcon(space);
        spot23.setIcon(space);
        spot24.setIcon(space);
    }

    // method to check and update locations of asteroids into the array prior to proccessing
    public void UpdateAsteroidLoc() {
        for (int i = 0; i < 25; i++) {
            // fill in first column of array with button name
            asteroidLoc[i][0] = "spot" + i;
            // fill in all locations with space so they can be compared unlike null
            asteroidLoc[i][1] = "space";
            // check and fill in asteroid into spaces with asteroids
            if (i == 0) {
                if (spot0.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 1) {
                if (spot1.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 2) {
                if (spot2.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 3) {
                if (spot3.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 4) {
                if (spot4.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 5) {
                if (spot5.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 6) {
                if (spot6.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 7) {
                if (spot7.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 8) {
                if (spot8.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 9) {
                if (spot9.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 10) {
                if (spot10.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 11) {
                if (spot11.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 12) {
                if (spot12.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 13) {
                if (spot13.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 14) {
                if (spot14.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 15) {
                if (spot15.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 16) {
                if (spot16.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 17) {
                if (spot17.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 18) {
                if (spot18.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 19) {
                if (spot19.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 20) {
                if (spot20.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 21) {
                if (spot21.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 22) {
                if (spot22.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 23) {
                if (spot23.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
            if (i == 24) {
                if (spot24.getIcon().equals(asteroid)) {
                    asteroidLoc[i][1] = "asteroid";
                }
            }
        }
    }

    // method to create a new asteroid in a random location in the top row
    public void NewAsteroid() {
        // collect new random location
        int newLoc = new Random().nextInt(5);
        // place new asteroid based on location
        if (newLoc == 0)
            spot0.setIcon(asteroid);
        if (newLoc == 1)
            spot1.setIcon(asteroid);
        if (newLoc == 2)
            spot2.setIcon(asteroid);
        if (newLoc == 3)
            spot3.setIcon(asteroid);
        if (newLoc == 4)
            spot4.setIcon(asteroid);
        // call UpdateAsteroidLoc() to update location
        UpdateAsteroidLoc();
    }

    // method that deals with all things asteroid in the game
    public void Asteroids(String check) {
        // if the method is called and the input is right
        if (check.equals("right")) {
            // add to number destroyed and recalulate score
            numberDestroyed++;
            score += 5 * round;
            // destroy the closest asteroid
            if (asteroidLoc[24][1].equals("asteroid")) {
                spot24.setIcon(space);
            } else if (asteroidLoc[23][1].equals("asteroid")) {
                spot23.setIcon(space);
            } else if (asteroidLoc[22][1].equals("asteroid")) {
                spot22.setIcon(space);
            } else if (asteroidLoc[21][1].equals("asteroid")) {
                spot21.setIcon(space);
            } else if (asteroidLoc[20][1].equals("asteroid")) {
                spot20.setIcon(space);
            } else if (asteroidLoc[19][1].equals("asteroid")) {
                spot19.setIcon(space);
            } else if (asteroidLoc[18][1].equals("asteroid")) {
                spot18.setIcon(space);
            } else if (asteroidLoc[17][1].equals("asteroid")) {
                spot17.setIcon(space);
            } else if (asteroidLoc[16][1].equals("asteroid")) {
                spot16.setIcon(space);
            } else if (asteroidLoc[15][1].equals("asteroid")) {
                spot15.setIcon(space);
            } else if (asteroidLoc[14][1].equals("asteroid")) {
                spot14.setIcon(space);
            } else if (asteroidLoc[13][1].equals("asteroid")) {
                spot13.setIcon(space);
            } else if (asteroidLoc[12][1].equals("asteroid")) {
                spot12.setIcon(space);
            } else if (asteroidLoc[11][1].equals("asteroid")) {
                spot11.setIcon(space);
            } else if (asteroidLoc[10][1].equals("asteroid")) {
                spot10.setIcon(space);
            } else if (asteroidLoc[9][1].equals("asteroid")) {
                spot9.setIcon(space);
            } else if (asteroidLoc[8][1].equals("asteroid")) {
                spot8.setIcon(space);
            } else if (asteroidLoc[7][1].equals("asteroid")) {
                spot7.setIcon(space);
            } else if (asteroidLoc[6][1].equals("asteroid")) {
                spot6.setIcon(space);
            } else if (asteroidLoc[5][1].equals("asteroid")) {
                spot5.setIcon(space);
            } else if (asteroidLoc[4][1].equals("asteroid")) {
                spot4.setIcon(space);
            } else if (asteroidLoc[3][1].equals("asteroid")) {
                spot3.setIcon(space);
            } else if (asteroidLoc[2][1].equals("asteroid")) {
                spot2.setIcon(space);
            } else if (asteroidLoc[1][1].equals("asteroid")) {
                spot1.setIcon(space);
            } else if (asteroidLoc[0][1].equals("asteroid")) {
                spot0.setIcon(space);
            }
            // call UpdateAsteroidLoc() to update locations
            UpdateAsteroidLoc();
            // shift asteroids down based on position
            if (asteroidLoc[19][1].equals("asteroid")) {
                spot19.setIcon(space);
                spot24.setIcon(asteroid);
            }
            if (asteroidLoc[18][1].equals("asteroid")) {
                spot18.setIcon(space);
                spot23.setIcon(asteroid);
            }
            if (asteroidLoc[17][1].equals("asteroid")) {
                spot17.setIcon(space);
                spot22.setIcon(asteroid);
            }
            if (asteroidLoc[16][1].equals("asteroid")) {
                spot16.setIcon(space);
                spot21.setIcon(asteroid);
            }
            if (asteroidLoc[15][1].equals("asteroid")) {
                spot15.setIcon(space);
                spot20.setIcon(asteroid);
            }
            if (asteroidLoc[14][1].equals("asteroid")) {
                spot14.setIcon(space);
                spot19.setIcon(asteroid);
            }
            if (asteroidLoc[13][1].equals("asteroid")) {
                spot13.setIcon(space);
                spot18.setIcon(asteroid);
            }
            if (asteroidLoc[12][1].equals("asteroid")) {
                spot12.setIcon(space);
                spot17.setIcon(asteroid);
            }
            if (asteroidLoc[11][1].equals("asteroid")) {
                spot11.setIcon(space);
                spot16.setIcon(asteroid);
            }
            if (asteroidLoc[10][1].equals("asteroid")) {
                spot10.setIcon(space);
                spot15.setIcon(asteroid);
            }
            if (asteroidLoc[9][1].equals("asteroid")) {
                spot9.setIcon(space);
                spot14.setIcon(asteroid);
            }
            if (asteroidLoc[8][1].equals("asteroid")) {
                spot8.setIcon(space);
                spot13.setIcon(asteroid);
            }
            if (asteroidLoc[7][1].equals("asteroid")) {
                spot7.setIcon(space);
                spot12.setIcon(asteroid);
            }
            if (asteroidLoc[6][1].equals("asteroid")) {
                spot6.setIcon(space);
                spot11.setIcon(asteroid);
            }
            if (asteroidLoc[5][1].equals("asteroid")) {
                spot5.setIcon(space);
                spot10.setIcon(asteroid);
            }
            if (asteroidLoc[4][1].equals("asteroid")) {
                spot4.setIcon(space);
                spot9.setIcon(asteroid);
            }
            if (asteroidLoc[3][1].equals("asteroid")) {
                spot3.setIcon(space);
                spot8.setIcon(asteroid);
            }
            if (asteroidLoc[2][1].equals("asteroid")) {
                spot2.setIcon(space);
                spot7.setIcon(asteroid);
            }
            if (asteroidLoc[1][1].equals("asteroid")) {
                spot1.setIcon(space);
                spot6.setIcon(asteroid);
            }
            if (asteroidLoc[0][1].equals("asteroid")) {
                spot0.setIcon(space);
                spot5.setIcon(asteroid);
            }
            // call UpdateAsteroidLoc() to update locations
            UpdateAsteroidLoc();
            // call NewAsteroid() to randomly create a new asteroid in the top row
            NewAsteroid();
        // if method is called and input is wrong
        } else if (check.equals("wrong")) {
            // check if there is an asteroid in the lowest row
            if (asteroidLoc[24][1].equals("asteroid")
                    || asteroidLoc[23][1].equals("asteroid")
                    || asteroidLoc[22][1].equals("asteroid")
                    || asteroidLoc[21][1].equals("asteroid")
                    || asteroidLoc[20][1].equals("asteroid")) {
                // if there is lower health
                numHealth--;
                // set healthbar based on updated health
                if (numHealth == 6) {
                    healthBar.setIcon(sixH);
                } else if (numHealth == 5) {
                    healthBar.setIcon(fiveH);
                } else if (numHealth == 4) {
                    healthBar.setIcon(fourH);
                } else if (numHealth == 3) {
                    healthBar.setIcon(threeH);
                } else if (numHealth == 2) {
                    healthBar.setIcon(twoH);
                } else if (numHealth == 1) {
                    healthBar.setIcon(oneH);
                }
                if (numHealth == 0) {
                    healthBar.setIcon(noH);
                }
                // remove asteroid that damaged the ship
                if (asteroidLoc[24][1].equals("asteroid")) {
                    spot24.setIcon(space);
                } else if (asteroidLoc[23][1].equals("asteroid")) {
                    spot23.setIcon(space);
                } else if (asteroidLoc[22][1].equals("asteroid")) {
                    spot22.setIcon(space);
                } else if (asteroidLoc[21][1].equals("asteroid")) {
                    spot21.setIcon(space);
                } else if (asteroidLoc[20][1].equals("asteroid")) {
                    spot20.setIcon(space);
                }
                // call UpdateAsteroidLoc() to update locations
                UpdateAsteroidLoc();
            }
            // shift asteroids down based on location
            if (asteroidLoc[19][1].equals("asteroid")) {
                spot19.setIcon(space);
                spot24.setIcon(asteroid);
            }
            if (asteroidLoc[18][1].equals("asteroid")) {
                spot18.setIcon(space);
                spot23.setIcon(asteroid);
            }
            if (asteroidLoc[17][1].equals("asteroid")) {
                spot17.setIcon(space);
                spot22.setIcon(asteroid);
            }
            if (asteroidLoc[16][1].equals("asteroid")) {
                spot16.setIcon(space);
                spot21.setIcon(asteroid);
            }
            if (asteroidLoc[15][1].equals("asteroid")) {
                spot15.setIcon(space);
                spot20.setIcon(asteroid);
            }
            if (asteroidLoc[14][1].equals("asteroid")) {
                spot14.setIcon(space);
                spot19.setIcon(asteroid);
            }
            if (asteroidLoc[13][1].equals("asteroid")) {
                spot13.setIcon(space);
                spot18.setIcon(asteroid);
            }
            if (asteroidLoc[12][1].equals("asteroid")) {
                spot12.setIcon(space);
                spot17.setIcon(asteroid);
            }
            if (asteroidLoc[11][1].equals("asteroid")) {
                spot11.setIcon(space);
                spot16.setIcon(asteroid);
            }
            if (asteroidLoc[10][1].equals("asteroid")) {
                spot10.setIcon(space);
                spot15.setIcon(asteroid);
            }
            if (asteroidLoc[9][1].equals("asteroid")) {
                spot9.setIcon(space);
                spot14.setIcon(asteroid);
            }
            if (asteroidLoc[8][1].equals("asteroid")) {
                spot8.setIcon(space);
                spot13.setIcon(asteroid);
            }
            if (asteroidLoc[7][1].equals("asteroid")) {
                spot7.setIcon(space);
                spot12.setIcon(asteroid);
            }
            if (asteroidLoc[6][1].equals("asteroid")) {
                spot6.setIcon(space);
                spot11.setIcon(asteroid);
            }
            if (asteroidLoc[5][1].equals("asteroid")) {
                spot5.setIcon(space);
                spot10.setIcon(asteroid);
            }
            if (asteroidLoc[4][1].equals("asteroid")) {
                spot4.setIcon(space);
                spot9.setIcon(asteroid);
            }
            if (asteroidLoc[3][1].equals("asteroid")) {
                spot3.setIcon(space);
                spot8.setIcon(asteroid);
            }
            if (asteroidLoc[2][1].equals("asteroid")) {
                spot2.setIcon(space);
                spot7.setIcon(asteroid);
            }
            if (asteroidLoc[1][1].equals("asteroid")) {
                spot1.setIcon(space);
                spot6.setIcon(asteroid);
            }
            if (asteroidLoc[0][1].equals("asteroid")) {
                spot0.setIcon(space);
                spot5.setIcon(asteroid);
            }
            // call UpdateAsteroidLoc() to update asteroid locations
            UpdateAsteroidLoc();
            // create a New Asteroid in a random loation in the top row
            NewAsteroid();
        }
    }

    public void simonDisable() {
        S1.setDisabledIcon(defaultIcon);
        S1.setEnabled(false);
        S2.setDisabledIcon(defaultIcon);
        S2.setEnabled(false);
        S3.setDisabledIcon(defaultIcon);
        S3.setEnabled(false);
        S4.setDisabledIcon(defaultIcon);
        S4.setEnabled(false);
        S5.setDisabledIcon(defaultIcon);
        S5.setEnabled(false);
        S6.setDisabledIcon(defaultIcon);
        S6.setEnabled(false);
        S7.setDisabledIcon(defaultIcon);
        S7.setEnabled(false);
        S8.setDisabledIcon(defaultIcon);
        S8.setEnabled(false);
        S9.setDisabledIcon(defaultIcon);
        S9.setEnabled(false);
    }

    public void simonEnable() {
        S1.setEnabled(true);
        S1.setIcon(defaultIcon);
        S1.setDisabledIcon(defaultIcon);
        S2.setEnabled(true);
        S2.setIcon(defaultIcon);
        S2.setDisabledIcon(defaultIcon);
        S3.setEnabled(true);
        S3.setIcon(defaultIcon);
        S3.setDisabledIcon(defaultIcon);
        S4.setEnabled(true);
        S4.setIcon(defaultIcon);
        S4.setDisabledIcon(defaultIcon);
        S5.setEnabled(true);
        S5.setIcon(defaultIcon);
        S5.setDisabledIcon(defaultIcon);
        S6.setEnabled(true);
        S6.setIcon(defaultIcon);
        S6.setDisabledIcon(defaultIcon);
        S7.setEnabled(true);
        S7.setIcon(defaultIcon);
        S7.setDisabledIcon(defaultIcon);
        S8.setEnabled(true);
        S8.setIcon(defaultIcon);
        S8.setDisabledIcon(defaultIcon);
        S9.setEnabled(true);
        S9.setIcon(defaultIcon);
        S9.setDisabledIcon(defaultIcon);
    }

    public void simonSays() {

        // set timer to round speed
        if (patternSize == 3) {
            for (int y = 0; y < patternSize; y++) {
                pattern.add((int) ((Math.random() * ((max - min) + 1)) + min));
            }
        } else if (patternSize > 3) {
            pattern.add((int) ((Math.random() * ((max - min) + 1)) + min));
        }

        // converts array list to array
        simonPattern = pattern.toArray(new Integer[0]);
        // display each specific button based on patternSize using timer
        double exponent = (-1) * (round - 1);
        double time = (1000 * ((Math.pow(2.0, exponent))));
        delay = Math.round((int) (time));
        Timer timer = new Timer(delay, null);
        timer.addActionListener(new ActionListener() {

            int x = 0;

            public void actionPerformed(ActionEvent e) {
                simonDisable();
                if (x <= simonPattern.length - 1) {
                    if (simonPattern[x] == 1) {
                        S1.setDisabledIcon(chosenIcon);
                    } else if (simonPattern[x] == 2) {
                        S2.setDisabledIcon(chosenIcon);
                    } else if (simonPattern[x] == 3) {
                        S3.setDisabledIcon(chosenIcon);
                    } else if (simonPattern[x] == 4) {
                        S4.setDisabledIcon(chosenIcon);
                    } else if (simonPattern[x] == 5) {
                        S5.setDisabledIcon(chosenIcon);
                    } else if (simonPattern[x] == 6) {
                        S6.setDisabledIcon(chosenIcon);
                    } else if (simonPattern[x] == 7) {
                        S7.setDisabledIcon(chosenIcon);
                    } else if (simonPattern[x] == 8) {
                        S8.setDisabledIcon(chosenIcon);
                    } else if (simonPattern[x] == 9) {
                        S9.setDisabledIcon(chosenIcon);
                    }
                } else if (x == simonPattern.length) {
                    timer.stop();
                    simonEnable();
                }
                x++;
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    public void checkPattern() {
        inputPattern = new Integer[0];
        inputPattern = ipattern.toArray(inputPattern);
        String check = "right";
        for (int i = 0; i < inputPattern.length; i++) {
            if (inputPattern[i] != simonPattern[i]) {
                check = "wrong";
                break;
            }
        }
        // call asteroids and reset input pattern to blank
        inputPattern = new Integer[0];
        ipattern.clear();
        Asteroids(check);
        numDestroyed.setText("Destroyed: " + numberDestroyed);
        scoreNum.setText("Score: " + score);
        patternSize++;
        if (patternSize == 8 && numHealth != 0) {
            patternSize = 3;
            round++;
            pattern.clear();
            ipattern.clear();
            simonSays();
        } else if (numHealth == 0) {
            if (score > highScores) {
                highScores = score;
                simonDisable();

                String name;
                name = JOptionPane.showInputDialog("You have beaten the high score! Please enter your name: ");
                names = name;
                HighScore();
                
                JPanel panel1 = new JPanel();
                JTextField txtScore = new JTextField(10);
                JTextField txtScore2 = new JTextField(10);
                JLabel lblScore = new JLabel("Your Score: ");
                JLabel lblScore2 = new JLabel("High Score: ");
                JLabel lblMessage = new JLabel("Congratulations you have made the new high score!");
                JButton btnRestart = new JButton("Restart");
                
                btnRestart.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        startResetButton.doClick();
                    }
                });
                JButton btnExit = new JButton("Exit");

                btnExit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });

                panel1.add(lblScore);
                panel1.add(txtScore);
                panel1.add(lblScore2);
                panel1.add(txtScore2);
                panel1.add(btnRestart);
                panel1.add(btnExit);
                panel1.add(lblMessage);

                txtScore.setText(String.valueOf(score));
                txtScore.setEditable(false);
                txtScore2.setText(String.valueOf(highScores));
                txtScore2.setEditable(false);

                Object[] options = {};
                JOptionPane.showOptionDialog(null, panel1, "", JOptionPane.DEFAULT_OPTION, JOptionPane.CANCEL_OPTION, null, options, null);
            }
            simonDisable();
            JPanel panel1 = new JPanel();
            JTextField txtScore = new JTextField(10);
            JTextField txtScore2 = new JTextField(10);
            JLabel lblScore = new JLabel("Your Score: ");
            JLabel lblScore2 = new JLabel("High Score: ");
            JLabel lblMessage = new JLabel("Please try again to beat the high score!");
            JButton btnRestart = new JButton("Restart");
            
            btnRestart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    startResetButton.doClick();
                }
            });
            JButton btnExit = new JButton("Exit");
            
            btnExit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            
            panel1.add(lblScore);
            panel1.add(txtScore);
            panel1.add(lblScore2);
            panel1.add(txtScore2);
            panel1.add(btnRestart); 
            panel1.add(btnExit);
            panel1.add(lblMessage);
            
            txtScore.setText(String.valueOf(score));
            txtScore.setEditable(false);
            txtScore2.setText(String.valueOf(highScores));
            txtScore2.setEditable(false);
            Object[] options = {};
            JOptionPane.showOptionDialog(null, panel1, "", JOptionPane.DEFAULT_OPTION, JOptionPane.CANCEL_OPTION, null, options, null);
        } else{
            simonSays();
        }
    }
    public static void main() {
        JFrame frame = new JFrame("Homebase Defence");
        frame.setContentPane(new HomebaseDefence().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(390, 755);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }
    
    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(-16777216));
        spot0 = new JButton();
        spot0.setBackground(new Color(-16777216));
        spot0.setBorderPainted(false);
        spot0.setContentAreaFilled(false);
        spot0.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot0.setRequestFocusEnabled(false);
        spot0.setRolloverEnabled(false);
        spot0.setText("");
        spot0.setVerifyInputWhenFocusTarget(false);
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot0, gbc);
        spot1 = new JButton();
        spot1.setBackground(new Color(-16777216));
        spot1.setBorderPainted(false);
        spot1.setContentAreaFilled(false);
        spot1.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot1.setRequestFocusEnabled(false);
        spot1.setRolloverEnabled(false);
        spot1.setText("");
        spot1.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot1, gbc);
        spot2 = new JButton();
        spot2.setBackground(new Color(-16777216));
        spot2.setBorderPainted(false);
        spot2.setContentAreaFilled(false);
        spot2.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot2.setRequestFocusEnabled(false);
        spot2.setRolloverEnabled(false);
        spot2.setText("");
        spot2.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot2, gbc);
        spot3 = new JButton();
        spot3.setBackground(new Color(-16777216));
        spot3.setBorderPainted(false);
        spot3.setContentAreaFilled(false);
        spot3.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot3.setRequestFocusEnabled(false);
        spot3.setRolloverEnabled(false);
        spot3.setText("");
        spot3.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot3, gbc);
        spot4 = new JButton();
        spot4.setBackground(new Color(-16777216));
        spot4.setBorderPainted(false);
        spot4.setContentAreaFilled(false);
        spot4.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot4.setRequestFocusEnabled(false);
        spot4.setRolloverEnabled(false);
        spot4.setText("");
        spot4.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot4, gbc);
        spot5 = new JButton();
        spot5.setBackground(new Color(-16777216));
        spot5.setBorderPainted(false);
        spot5.setContentAreaFilled(false);
        spot5.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot5.setRequestFocusEnabled(false);
        spot5.setRolloverEnabled(false);
        spot5.setText("");
        spot5.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot5, gbc);
        spot6 = new JButton();
        spot6.setBackground(new Color(-16777216));
        spot6.setBorderPainted(false);
        spot6.setContentAreaFilled(false);
        spot6.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot6.setRequestFocusEnabled(false);
        spot6.setRolloverEnabled(false);
        spot6.setText("");
        spot6.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot6, gbc);
        spot7 = new JButton();
        spot7.setBackground(new Color(-16777216));
        spot7.setBorderPainted(false);
        spot7.setContentAreaFilled(false);
        spot7.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot7.setRequestFocusEnabled(false);
        spot7.setRolloverEnabled(false);
        spot7.setText("");
        spot7.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot7, gbc);
        spot8 = new JButton();
        spot8.setBackground(new Color(-16777216));
        spot8.setBorderPainted(false);
        spot8.setContentAreaFilled(false);
        spot8.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot8.setRequestFocusEnabled(false);
        spot8.setRolloverEnabled(false);
        spot8.setText("");
        spot8.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot8, gbc);
        spot9 = new JButton();
        spot9.setBackground(new Color(-16777216));
        spot9.setBorderPainted(false);
        spot9.setContentAreaFilled(false);
        spot9.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot9.setRequestFocusEnabled(false);
        spot9.setRolloverEnabled(false);
        spot9.setText("");
        spot9.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot9, gbc);
        spot20 = new JButton();
        spot20.setBackground(new Color(-16777216));
        spot20.setBorderPainted(false);
        spot20.setContentAreaFilled(false);
        spot20.setFocusPainted(false);
        spot20.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot20.setRequestFocusEnabled(false);
        spot20.setRolloverEnabled(false);
        spot20.setText("");
        spot20.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot20, gbc);
        spot16 = new JButton();
        spot16.setBackground(new Color(-16777216));
        spot16.setBorderPainted(false);
        spot16.setContentAreaFilled(false);
        spot16.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot16.setRequestFocusEnabled(false);
        spot16.setRolloverEnabled(false);
        spot16.setText("");
        spot16.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot16, gbc);
        spot12 = new JButton();
        spot12.setBackground(new Color(-16777216));
        spot12.setBorderPainted(false);
        spot12.setContentAreaFilled(false);
        spot12.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot12.setRequestFocusEnabled(false);
        spot12.setRolloverEnabled(false);
        spot12.setText("");
        spot12.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot12, gbc);
        spot10 = new JButton();
        spot10.setBackground(new Color(-16777216));
        spot10.setBorderPainted(false);
        spot10.setContentAreaFilled(false);
        spot10.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot10.setRequestFocusEnabled(false);
        spot10.setRolloverEnabled(false);
        spot10.setText("");
        spot10.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot10, gbc);
        spot11 = new JButton();
        spot11.setBackground(new Color(-16777216));
        spot11.setBorderPainted(false);
        spot11.setContentAreaFilled(false);
        spot11.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot11.setRequestFocusEnabled(false);
        spot11.setRolloverEnabled(false);
        spot11.setText("");
        spot11.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot11, gbc);
        spot13 = new JButton();
        spot13.setBackground(new Color(-16777216));
        spot13.setBorderPainted(false);
        spot13.setContentAreaFilled(false);
        spot13.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot13.setRequestFocusEnabled(false);
        spot13.setRolloverEnabled(false);
        spot13.setText("");
        spot13.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot13, gbc);
        spot14 = new JButton();
        spot14.setBackground(new Color(-16777216));
        spot14.setBorderPainted(false);
        spot14.setContentAreaFilled(false);
        spot14.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot14.setRequestFocusEnabled(false);
        spot14.setRolloverEnabled(false);
        spot14.setText("");
        spot14.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot14, gbc);
        spot19 = new JButton();
        spot19.setBackground(new Color(-16777216));
        spot19.setBorderPainted(false);
        spot19.setContentAreaFilled(false);
        spot19.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot19.setRequestFocusEnabled(false);
        spot19.setRolloverEnabled(false);
        spot19.setText("");
        spot19.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot19, gbc);
        spot24 = new JButton();
        spot24.setBackground(new Color(-16777216));
        spot24.setBorderPainted(false);
        spot24.setContentAreaFilled(false);
        spot24.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot24.setRequestFocusEnabled(false);
        spot24.setRolloverEnabled(false);
        spot24.setText("");
        spot24.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 7;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot24, gbc);
        spot23 = new JButton();
        spot23.setBackground(new Color(-16777216));
        spot23.setBorderPainted(false);
        spot23.setContentAreaFilled(false);
        spot23.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot23.setRequestFocusEnabled(false);
        spot23.setRolloverEnabled(false);
        spot23.setText("");
        spot23.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot23, gbc);
        spot18 = new JButton();
        spot18.setBackground(new Color(-16777216));
        spot18.setBorderPainted(false);
        spot18.setContentAreaFilled(false);
        spot18.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot18.setRequestFocusEnabled(false);
        spot18.setRolloverEnabled(false);
        spot18.setText("");
        spot18.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot18, gbc);
        spot17 = new JButton();
        spot17.setBackground(new Color(-16777216));
        spot17.setBorderPainted(false);
        spot17.setContentAreaFilled(false);
        spot17.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot17.setRequestFocusEnabled(false);
        spot17.setRolloverEnabled(false);
        spot17.setText("");
        spot17.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot17, gbc);
        spot22 = new JButton();
        spot22.setBackground(new Color(-16777216));
        spot22.setBorderPainted(false);
        spot22.setContentAreaFilled(false);
        spot22.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot22.setRequestFocusEnabled(false);
        spot22.setRolloverEnabled(false);
        spot22.setText("");
        spot22.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot22, gbc);
        spot21 = new JButton();
        spot21.setBackground(new Color(-16777216));
        spot21.setBorderPainted(false);
        spot21.setContentAreaFilled(false);
        spot21.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot21.setRequestFocusEnabled(false);
        spot21.setRolloverEnabled(false);
        spot21.setText("");
        spot21.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot21, gbc);
        spot15 = new JButton();
        spot15.setBackground(new Color(-16777216));
        spot15.setBorderPainted(false);
        spot15.setContentAreaFilled(false);
        spot15.setFocusPainted(false);
        spot15.setFocusable(false);
        spot15.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/spaceBG.png")));
        spot15.setRequestFocusEnabled(false);
        spot15.setRolloverEnabled(false);
        spot15.setText("");
        spot15.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spot15, gbc);
        startResetButton = new JButton();
        startResetButton.setBackground(new Color(-16777216));
        startResetButton.setBorderPainted(false);
        Font startResetButtonFont = this.$$$getFont$$$("Calibri", -1, 9, startResetButton.getFont());
        if (startResetButtonFont != null) startResetButton.setFont(startResetButtonFont);
        startResetButton.setForeground(new Color(-1));
        startResetButton.setHorizontalTextPosition(0);
        startResetButton.setText("Start");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(startResetButton, gbc);
        S1 = new JButton();
        S1.setMaximumSize(new Dimension(74, 30));
        S1.setMinimumSize(new Dimension(74, 30));
        S1.setText("");
        S1.setIcon(defaultIcon);
        S1.setIcon(defaultIcon);
        S1.setBackground(new Color(17,145,208));
        S1.setEnabled(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 11;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(S1, gbc);
        S2 = new JButton();
        S2.setMaximumSize(new Dimension(74, 30));
        S2.setMinimumSize(new Dimension(74, 30));
        S2.setText("");
        S2.setIcon(defaultIcon);
        S2.setIcon(defaultIcon);
        S2.setEnabled(false);
        S2.setBackground(new Color(17,145,208));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 11;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(S2, gbc);
        S3 = new JButton();
        S3.setMaximumSize(new Dimension(74, 30));
        S3.setMinimumSize(new Dimension(74, 30));
        S3.setText("");
        S3.setIcon(defaultIcon);
        S3.setIcon(defaultIcon);
        S3.setEnabled(false);
        S3.setBackground(new Color(17,145,208));
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 11;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(S3, gbc);
        S4 = new JButton();
        S4.setMaximumSize(new Dimension(74, 30));
        S4.setMinimumSize(new Dimension(74, 30));
        S4.setText("");
        S4.setIcon(defaultIcon);
        S4.setIcon(defaultIcon);
        S4.setEnabled(false);
        S4.setBackground(new Color(17,145,208));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 12;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(S4, gbc);
        S5 = new JButton();
        S5.setMaximumSize(new Dimension(74, 30));
        S5.setMinimumSize(new Dimension(74, 30));
        S5.setText("");
        S5.setIcon(defaultIcon);
        S5.setIcon(defaultIcon);
        S5.setEnabled(false);
        S5.setBackground(new Color(17,145,208));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 12;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(S5, gbc);
        S6 = new JButton();
        S6.setMaximumSize(new Dimension(74, 30));
        S6.setMinimumSize(new Dimension(74, 30));
        S6.setText("");
        S6.setIcon(defaultIcon);
        S6.setIcon(defaultIcon);
        S6.setEnabled(false);
        S6.setBackground(new Color(17,145,208));
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 12;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(S6, gbc);
        S7 = new JButton();
        S7.setMaximumSize(new Dimension(74, 30));
        S7.setMinimumSize(new Dimension(74, 30));
        S7.setText("");
        S7.setIcon(defaultIcon);
        S7.setIcon(defaultIcon);
        S7.setEnabled(false);
        S7.setBackground(new Color(17,145,208));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 13;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(S7, gbc);
        S8 = new JButton();
        S8.setMaximumSize(new Dimension(74, 30));
        S8.setMinimumSize(new Dimension(74, 30));
        S8.setText("");
        S8.setIcon(defaultIcon);
        S8.setIcon(defaultIcon);
        S8.setEnabled(false);
        S8.setBackground(new Color(17,145,208));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 13;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(S8, gbc);
        S9 = new JButton();
        S9.setMaximumSize(new Dimension(74, 30));
        S9.setMinimumSize(new Dimension(74, 30));
        S9.setText("");
        S9.setIcon(defaultIcon);
        S9.setIcon(defaultIcon);
        S9.setEnabled(false);
        S9.setBackground(new Color(17,145,208));
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 13;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(S9, gbc);
        exitButton = new JButton();
        exitButton.setBackground(new Color(-16777216));
        exitButton.setBorderPainted(false);
        Font exitButtonFont = this.$$$getFont$$$("Calibri", -1, 9, exitButton.getFont());
        if (exitButtonFont != null) exitButton.setFont(exitButtonFont);
        exitButton.setForeground(new Color(-1));
        exitButton.setHorizontalTextPosition(0);
        exitButton.setText("Exit");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(exitButton, gbc);
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Calibri", -1, 9, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-1));
        label1.setHorizontalAlignment(0);
        label1.setHorizontalTextPosition(0);
        label1.setText("High Score:");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 11;
        gbc.weightx = 1.0;
        mainPanel.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setBackground(new Color(-16777216));
        Font label2Font = this.$$$getFont$$$("Calibri", -1, 12, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setForeground(new Color(-1));
        label2.setText("Defense Contoller");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.gridwidth = 3;
        mainPanel.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setBackground(new Color(-16777216));
        Font label3Font = this.$$$getFont$$$("Calibri", -1, 36, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setForeground(new Color(-1));
        label3.setText("Homebase Defence");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        gbc.weightx = 1.0;
        mainPanel.add(label3, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(spacer2, gbc);
        final JButton button1 = new JButton();
        button1.setBackground(new Color(-16777216));
        button1.setBorderPainted(false);
        button1.setContentAreaFilled(false);
        button1.setFocusPainted(false);
        button1.setFocusable(false);
        button1.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/shipP1.png")));
        button1.setRequestFocusEnabled(false);
        button1.setRolloverEnabled(false);
        button1.setText("");
        button1.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(button1, gbc);
        final JButton button2 = new JButton();
        button2.setBackground(new Color(-16777216));
        button2.setBorderPainted(false);
        button2.setContentAreaFilled(false);
        button2.setFocusPainted(false);
        button2.setFocusable(false);
        button2.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/shipP2.png")));
        button2.setRequestFocusEnabled(false);
        button2.setRolloverEnabled(false);
        button2.setText("");
        button2.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(button2, gbc);
        final JButton button3 = new JButton();
        button3.setBackground(new Color(-16777216));
        button3.setBorderPainted(false);
        button3.setContentAreaFilled(false);
        button3.setFocusPainted(false);
        button3.setFocusable(false);
        button3.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/shipP3.png")));
        button3.setRequestFocusEnabled(false);
        button3.setRolloverEnabled(false);
        button3.setText("");
        button3.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 8;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(button3, gbc);
        final JButton button4 = new JButton();
        button4.setBackground(new Color(-16777216));
        button4.setBorderPainted(false);
        button4.setContentAreaFilled(false);
        button4.setFocusPainted(false);
        button4.setFocusable(false);
        button4.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/shipP4.png")));
        button4.setRequestFocusEnabled(false);
        button4.setRolloverEnabled(false);
        button4.setText("");
        button4.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 8;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(button4, gbc);
        final JButton button5 = new JButton();
        button5.setBackground(new Color(-16777216));
        button5.setBorderPainted(false);
        button5.setContentAreaFilled(false);
        button5.setFocusPainted(false);
        button5.setFocusable(false);
        button5.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/shipP5.png")));
        button5.setRequestFocusEnabled(false);
        button5.setRolloverEnabled(false);
        button5.setText("");
        button5.setVerifyInputWhenFocusTarget(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 8;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(button5, gbc);
        highName = new JLabel();
        Font highNameFont = this.$$$getFont$$$("Calibri", -1, 9, highName.getFont());
        if (highNameFont != null) highName.setFont(highNameFont);
        highName.setForeground(new Color(-1));
        highName.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 12;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(highName, gbc);
        highScore = new JLabel();
        Font highScoreFont = this.$$$getFont$$$("Calibri", -1, 9, highScore.getFont());
        if (highScoreFont != null) highScore.setFont(highScoreFont);
        highScore.setForeground(new Color(-1));
        highScore.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 13;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(highScore, gbc);
        numDestroyed = new JLabel();
        Font numDestroyedFont = this.$$$getFont$$$("Calibri", -1, 9, numDestroyed.getFont());
        if (numDestroyedFont != null) numDestroyed.setFont(numDestroyedFont);
        numDestroyed.setForeground(new Color(-1));
        numDestroyed.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 12;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(numDestroyed, gbc);
        scoreNum = new JLabel();
        Font scoreNumFont = this.$$$getFont$$$("Calibri", -1, 9, scoreNum.getFont());
        if (scoreNumFont != null) scoreNum.setFont(scoreNumFont);
        scoreNum.setForeground(new Color(-1));
        scoreNum.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 13;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(scoreNum, gbc);
        healthBar = new JButton();
        healthBar.setBackground(new Color(-16777216));
        healthBar.setBorderPainted(false);
        healthBar.setFocusPainted(false);
        healthBar.setFocusable(false);
        healthBar.setIcon(new ImageIcon(getClass().getResource("/Assets/Images/fullH.jpg")));
        healthBar.setRequestFocusEnabled(false);
        healthBar.setRolloverEnabled(false);
        healthBar.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(healthBar, gbc);
        final JLabel label4 = new JLabel();
        Font label4Font = this.$$$getFont$$$("Calibri", -1, -1, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setForeground(new Color(-1));
        label4.setText("Health: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 9;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(label4, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
