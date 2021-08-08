
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

import static java.lang.String.valueOf;
public class myFrame  extends JFrame implements KeyListener,ActionListener {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        new myFrame();
    }



    JTextField textfield = new JTextField();
    Timer t;
    int start;
    int time =60;
    int Health = 100;
    int y =0;
    ImageIcon rocketcolor= new ImageIcon("Resources/Rocket-PNG-Image.png");
    ImageIcon rocketicon= new ImageIcon("Resources/Rocket icon.png");

    ImageIcon healthpackimage= new ImageIcon("Resources/Health.png");

    JProgressBar HP = new JProgressBar();


    JMenuBar menuBar = new JMenuBar();

    JMenu filemenu = new JMenu("File");
    JMenu Editmenu = new JMenu("Edit");
    JMenu Help = new JMenu("Help");


    JMenuItem exitItem = new JMenuItem("Exit");


    JMenuItem framecoloritem = new JMenuItem("Change frame color");

    JMenuItem themeimage = new JMenuItem("Change theme image");

    JMenuItem textcoloritem = new JMenuItem("Change text color");

    JMenuItem restoredefaults = new JMenuItem("Restore defaults");

    JMenuItem howtoplay= new JMenuItem("How to play ?");

    JMenuItem removeimage = new JMenuItem("Remove theme image");

    JLabel Rocket = new JLabel();
    JLabel Rocket2 = new JLabel();

    JLabel laserLabel = new JLabel();
    JLabel laserLabel2 = new JLabel();
    JLabel laserLabel3 = new JLabel();
    JLabel laserLabel4 = new JLabel();
    JLabel laserLabel5 = new JLabel();
    JLabel laserLabel6 = new JLabel();
    JLabel laserLabel7 = new JLabel();
    JLabel laserLabel8 = new JLabel();
    JLabel laserLabel9 = new JLabel();
    JLabel laserLabel10 = new JLabel();
    JLabel laserLabel11 = new JLabel();
    JLabel laserLabel12 = new JLabel();
    JLabel laserLabel13 = new JLabel();
    JLabel greenlaser= new JLabel();
    JLabel countdownLabel = new JLabel("00:00");
    JLabel titlelabel= new JLabel();
    JLabel startlabel= new JLabel();
    JLabel pauselabel= new JLabel();
    JLabel exitlabel= new JLabel();
    JLabel playLabel= new JLabel();
    JLabel healthpackLabel= new JLabel();
    JLabel healthpackLabel2= new JLabel();
    JLabel spacelabel= new JLabel();

    JLabel restart= new JLabel();
    JLabel restart1= new JLabel();
    JLabel restart2= new JLabel();



    Random Random = new Random();
    ImageIcon greenlaserImage = new ImageIcon("Resources/GreenLaser.png");

    ImageIcon laserImage = new ImageIcon("Resources/Laser.png");
    ImageIcon rocketImage = new ImageIcon("Resources/Rocket.png");
    ImageIcon rocketImage2 = new ImageIcon("Resources/Rocket2 .png");

    ImageIcon spaceImage2 = new ImageIcon("Resources/space background.png");
    ImageIcon spaceImage = new ImageIcon("Resources/space background2.png");

    File dmg = new File("Resources/player_hurt.wav");
    Clip dmgClip;
    AudioInputStream audioInputStream ;


    File lose = new File("Resources/lose.wav");
    Clip loseClip;
    AudioInputStream audioInputStream2 ;


    File pickup = new File("Resources/pickup.wav");
    Clip pickupClip;
    AudioInputStream audioInputStream3 ;


    java.util.List<ImageIcon> iamgeList1 = java.util.List.of(spaceImage,spaceImage2);



  myFrame() throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException {



        audioInputStream2= AudioSystem.getAudioInputStream(lose);
        loseClip=AudioSystem.getClip();
        loseClip.open(audioInputStream2);


        audioInputStream3= AudioSystem.getAudioInputStream(pickup);
        pickupClip=AudioSystem.getClip();
        pickupClip.open(audioInputStream3);





        restart.setBounds(200, 200, 200, 200);
        restart.setText("again??");
        restart.setVisible(false);


        spacelabel.setBounds(0, 0, 600, 550);
        spacelabel.setIcon(spaceImage);

        filemenu.add(exitItem);

        Editmenu.add(framecoloritem);
        Editmenu.add(textcoloritem);
        Editmenu.add(themeimage);
        Editmenu.add(removeimage);
        Editmenu.add(restoredefaults);

        Help.add(howtoplay);

        menuBar.add(filemenu);
        menuBar.add(Editmenu);
        menuBar.add(Help);

        exitItem.addActionListener(this);
        framecoloritem.addActionListener(this);
        restoredefaults.addActionListener(this);
        textcoloritem.addActionListener(this);
        howtoplay.addActionListener(this);
        removeimage.addActionListener(this);
        themeimage.addActionListener(this);

        healthpackLabel.setBounds(50, 50, 100, 100);
        healthpackLabel.setIcon(healthpackimage);
        healthpackLabel.setVisible(false);

        healthpackLabel2.setBounds(50, 50, 100, 100);
        healthpackLabel2.setIcon(healthpackimage);
        healthpackLabel2.setVisible(false);


        textfield.setBounds(0, 50, 750, 150);

        textfield.setBackground(new Color(25, 25, 25));

        textfield.setForeground(new Color(7, 165, 162));

        textfield.setFont(new Font("Ink Free", Font.BOLD, 30));

        textfield.setBorder(BorderFactory.createBevelBorder(1));

        textfield.setHorizontalAlignment(JTextField.CENTER);

        textfield.setEditable(false);
        textfield.setVisible(false);


        HP.setBounds(0, 0, 100, 30);
        HP.setBackground(Color.black.darker());
        HP.setForeground(Color.red.darker());
        HP.setValue(Health);
        HP.setStringPainted(true);


        titlelabel.setBounds(0, 0, 750, 150);

        titlelabel.setBackground(new Color(42, 41, 41));

        titlelabel.setForeground(new Color(7, 165, 162));

        titlelabel.setFont(new Font("Ink Free", Font.BOLD, 30));

        titlelabel.setBorder(BorderFactory.createBevelBorder(1));

        titlelabel.setHorizontalAlignment(JLabel.CENTER);
        titlelabel.setText("Space Rocket Game   ");
        titlelabel.setIcon(rocketImage);
        titlelabel.setIconTextGap(-350);



        startlabel.setBounds(0, 200, 350, 50);

        startlabel.setBackground(new Color(42, 41, 41));

        startlabel.setForeground(new Color(7, 165, 162));

        startlabel.setFont(new Font("Ink Free", Font.BOLD, 20));
        startlabel.setBorder(BorderFactory.createBevelBorder(1));

        startlabel.setHorizontalAlignment(JLabel.CENTER);
        startlabel.setText("press Enter to start the game ");

        pauselabel.setBounds(0, 270, 350, 50);

        pauselabel.setBackground(new Color(42, 41, 41));

        pauselabel.setForeground(new Color(7, 165, 162));

        pauselabel.setFont(new Font("Ink Free", Font.BOLD, 20));

        pauselabel.setBorder(BorderFactory.createBevelBorder(1));

        pauselabel.setHorizontalAlignment(JLabel.CENTER);
        pauselabel.setText("press Space to pause the game ");

        exitlabel.setBounds(0, 340, 350, 50);

        exitlabel.setBackground(new Color(42, 41, 41));

        exitlabel.setForeground(new Color(7, 165, 162));

        exitlabel.setFont(new Font("Ink Free", Font.BOLD, 20));

        exitlabel.setBorder(BorderFactory.createBevelBorder(1));

        exitlabel.setHorizontalAlignment(JLabel.CENTER);

        exitlabel.setText("press Esc to exit the game ");

        greenlaser.setSize(new Dimension(50,150));
        greenlaser.setIcon(greenlaserImage);

        greenlaser.setVisible(false);
        laserLabel.setSize(new Dimension(50,150));
        laserLabel.setIcon(laserImage);
        laserLabel.setLocation(20,-40);

        laserLabel2.setSize(new Dimension(50,150));
        laserLabel2.setIcon(laserImage);
        laserLabel2.setLocation(40,-40);

        laserLabel3.setSize(new Dimension(50,150));

        laserLabel3.setIcon(laserImage);
        laserLabel3.setLocation(60,-40);

        laserLabel4.setSize(new Dimension(50,150));

        laserLabel4.setIcon(laserImage);
        laserLabel4.setLocation(100,-40);

        laserLabel5.setSize(new Dimension(50,150));
        laserLabel5.setLocation(120,-40);

        laserLabel5.setIcon(laserImage);
        laserLabel6.setSize(new Dimension(50,150));
        laserLabel6.setLocation(160,-40);

        laserLabel6.setIcon(laserImage);

        laserLabel7.setSize(new Dimension(50,150));
        laserLabel7.setIcon(laserImage);
        laserLabel7.setLocation(200,-40);

        laserLabel8.setSize(new Dimension(50,150));
        laserLabel8.setIcon(laserImage);
        laserLabel8.setLocation(240,-40);

        laserLabel9.setSize(new Dimension(50,150));

        laserLabel9.setIcon(laserImage);
        laserLabel9.setLocation(300,-40);

        laserLabel10.setSize(new Dimension(50,150));
        laserLabel10.setIcon(laserImage);
        laserLabel10.setLocation(380,-40);

        laserLabel11.setSize(new Dimension(50,150));
        laserLabel11.setLocation(340,-40);

        laserLabel11.setIcon(laserImage);

        laserLabel12.setSize(new Dimension(50,150));

        laserLabel12.setIcon(laserImage);
        laserLabel12.setLocation(420,-40);

        laserLabel13.setSize(new Dimension(50,150));
        laserLabel.setLocation(460,-40);

        laserLabel13.setIcon(laserImage);



        Rocket2.setBounds(-20, 40, 80, 80);
        Rocket2.setIcon(rocketImage2);
        Rocket2.setVisible(false);

        Rocket.setBounds(-20, 390, 80, 80);
        Rocket.setIcon(rocketImage);
        start = 1;





        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.black.darker());
        this.setSize(600, 550);
        this.setLocation(500,100);
        repaint();
        this.add(countdownLabel);
        this.setJMenuBar(menuBar);
        this.add(startlabel);
        this.add(pauselabel);
        this.add(exitlabel);
        this.add(titlelabel);
        this.add(textfield);

        this.setResizable(false);
        this.setIconImage(rocketicon.getImage());
        this.setLayout(null);
        this.addKeyListener(this);
        t = new Timer(1000, new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {
                time--;
                countdownLabel.setText(format(time / 60) + ":" + format(time % 60));
                if (time == 0) {
                    final Timer timer = (Timer) e.getSource();
                    timer.stop();

                }


            }

        });
        countdownLabel.setBounds(550, 0, 50, 20);

        while (Health >= 10) {
            audioInputStream = AudioSystem.getAudioInputStream(dmg);
            dmgClip = AudioSystem.getClip();
            dmgClip.open(audioInputStream);

            if (time==0){
                t.stop();


                start=2;
                this.getContentPane().removeAll();
                this.revalidate();
                getContentPane(). repaint();
                textfield.setVisible(true);
                textfield.setBounds(0, 50, 750, 150);

                textfield.setText("Congrats you won !!");
                this.add(textfield);;


            }





            this.add(spacelabel);



            move();






            if (time == 40) {
                healthpackLabel.setVisible(true);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520);
                int xrandomElement = xList.get(Random.nextInt(xList.size()));



                healthpackLabel.setLocation(xrandomElement, 350);
                this.add(healthpackLabel);

            }

            if (time == 20) {
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520);
                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                healthpackLabel2.setVisible(true);

                healthpackLabel2.setLocation(xrandomElement, 350);
                this.add(healthpackLabel2);

            }
            if (time==20){

                Rocket2.setVisible(true);

                greenlaser.setLocation(Rocket2.getX()+20,Rocket2.getY());
                this.add(greenlaser);
                this.add(Rocket2);
            }
            if (Health != 100) {

                if (Rocket.getLocation().getX() == healthpackLabel.getLocation().getX() && Rocket.getLocation().getY() == healthpackLabel.getLocation().getY()) {
                    Health += 50;
                    HP.setValue(Health);
                    System.out.println("HEaled");
                    healthpackLabel.setLocation(-180, -180);
                    System.out.println(Health);
                    pickupClip.start();
                    pickupClip.setMicrosecondPosition(0);

                }
                if (Rocket.getLocation().getX() == healthpackLabel2.getLocation().getX() && Rocket.getLocation().getY() == healthpackLabel2.getLocation().getY()) {
                    Health += 50;
                    HP.setValue(Health);
                    System.out.println("HEaled");
                    healthpackLabel2.setLocation(-180, -180);
                    System.out.println(Health);
                    pickupClip.start();
                    pickupClip.setMicrosecondPosition(0);
                }

            }
            if (Health >= 100) {
                Health = 100;
            }
            if ((laserLabel.getY() >= 500)) {


                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160,-180,-200);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);
                int xrandomElement = xList.get(Random.nextInt(xList.size()));

                int yrandomElement = yList.get(Random.nextInt(yList.size()));
                getContentPane().repaint();

                laserLabel.setLocation(xrandomElement, yrandomElement);

            }

            if ((laserLabel2.getY() >= 500)) {


                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));
                getContentPane().repaint();

                laserLabel2.setLocation(xrandomElement, yrandomElement);

            }

            if ((laserLabel3.getY() >= 500)) {


                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));
                getContentPane().repaint();

                laserLabel3.setLocation(xrandomElement, yrandomElement);

            }
            if ((laserLabel4.getY() >= 500)) {

                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));
                getContentPane().repaint();

                laserLabel4.setLocation(xrandomElement, yrandomElement);

            }
            if ((laserLabel5.getY() >= 500)) {

                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));
                getContentPane().repaint();

                laserLabel5.setLocation(xrandomElement, yrandomElement);

            }
            if ((laserLabel6.getY() >= 500)) {

                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));
                getContentPane().repaint();

                laserLabel6.setLocation(xrandomElement, yrandomElement);

            }
            if ((laserLabel7.getY() >= 500)) {


                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);
                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));

                laserLabel7.setLocation(xrandomElement, yrandomElement);

            }
            if ((laserLabel8.getY() >= 500)) {

                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);
                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));
                getContentPane().repaint();
                laserLabel8.setLocation(xrandomElement, yrandomElement);

            }
            if ((laserLabel9.getY() >= 500)) {

                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));
                getContentPane().repaint();

                laserLabel9.setLocation(xrandomElement, yrandomElement);

            }
            if ((laserLabel10.getY() >= 500)) {

                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));
                getContentPane().repaint();

                laserLabel10.setLocation(xrandomElement, yrandomElement);

            }
            if ((laserLabel11.getY() >= 500)) {


                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);
                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));
                getContentPane().repaint();

                laserLabel11.setLocation(xrandomElement, yrandomElement);

            }
            if ((laserLabel12.getY() >= 500)) {

                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);
                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));
                getContentPane().repaint();
                laserLabel12.setLocation(xrandomElement, yrandomElement);

            }
            if ((laserLabel13.getY() >= 500)) {

                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);
                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));
                getContentPane().repaint();
                laserLabel13.setLocation(xrandomElement, yrandomElement);

            }

            if ((greenlaser.getY() >= 500)) {


                getContentPane().repaint();
                greenlaser.setLocation(Rocket2.getX()+20, Rocket2.getY());

            }


            if ((Rocket.getY() == laserLabel.getY() + 110 && Rocket.getX() == laserLabel.getX() - 20 || Rocket.getY() == laserLabel.getY() + 90 && Rocket.getX() == laserLabel.getX() - 20 || Rocket.getY() == laserLabel.getY() + 70 && Rocket.getX() == laserLabel.getX() - 20 || Rocket.getY() == laserLabel.getY() + 50 && Rocket.getX() == laserLabel.getX() - 20 || Rocket.getY() == laserLabel.getY() + 30 && Rocket.getX() == laserLabel.getX() - 20 || Rocket.getY() == laserLabel.getY() + 10 && Rocket.getX() == laserLabel.getX() - 20 || Rocket.getY() == laserLabel.getY() - 10 && Rocket.getX() == laserLabel.getX() - 20 || Rocket.getY() == laserLabel.getY() - 30 && Rocket.getX() == laserLabel.getX() - 20 || Rocket.getY() == laserLabel.getY() && Rocket.getX() + 80 == laserLabel.getX() + 50) || Rocket.getY() + 80 == laserLabel.getY() + 180 && Rocket.getX() + 80 == laserLabel.getX() + 50 || Rocket.getLocation(laserLabel.getLocation()) == laserLabel.getLocation() || laserLabel.getLocation() == Rocket.getLocation()) {


                java.util.List<Integer> xList = Arrays.asList(60, 120, 180, 240, 300, 360, 420, 480, 540);
                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);


                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));
                System.out.println(Rocket.getLocation());
                System.out.println(laserLabel.getLocation());
                Health -= 10;
                HP.setValue(Health);

                System.out.println("laser1");

                laserLabel.setLocation(xrandomElement, yrandomElement);
                dmgClip.start();
                dmgClip.setFramePosition(0);
            }

            if ((Rocket.getY() == laserLabel2.getY() + 110 && Rocket.getX() == laserLabel2.getX() - 20 || Rocket.getY() == laserLabel2.getY() + 90 && Rocket.getX() == laserLabel2.getX() - 20 || Rocket.getY() == laserLabel2.getY() + 70 && Rocket.getX() == laserLabel2.getX() - 20 || Rocket.getY() == laserLabel2.getY() + 50 && Rocket.getX() == laserLabel2.getX() - 20 || Rocket.getY() == laserLabel2.getY() + 30 && Rocket.getX() == laserLabel2.getX() - 20 || Rocket.getY() == laserLabel2.getY() + 10 && Rocket.getX() == laserLabel2.getX() - 20 || Rocket.getY() == laserLabel2.getY() - 10 && Rocket.getX() == laserLabel2.getX() - 20 || Rocket.getY() == laserLabel2.getY() - 30 && Rocket.getX() == laserLabel2.getX() - 20)) {

                java.util.List<Integer> xList = Arrays.asList(60, 120, 180, 240, 300, 360, 420, 480, 540);
                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                System.out.println("laser2");

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));
                System.out.println(Rocket.getLocation());
                System.out.println(laserLabel2.getLocation());
                Health -= 10;
                dmgClip.start();
                dmgClip.setMicrosecondPosition(0);

                HP.setValue(Health);
                laserLabel2.setLocation(xrandomElement, yrandomElement);
            }
            if ((Rocket.getY() == laserLabel3.getY() + 110 && Rocket.getX() == laserLabel3.getX() - 20 || Rocket.getY() == laserLabel3.getY() + 90 && Rocket.getX() == laserLabel3.getX() - 20 || Rocket.getY() == laserLabel3.getY() + 70 && Rocket.getX() == laserLabel3.getX() - 20 || Rocket.getY() == laserLabel3.getY() + 50 && Rocket.getX() == laserLabel3.getX() - 20 || Rocket.getY() == laserLabel3.getY() + 30 && Rocket.getX() == laserLabel3.getX() - 20 || Rocket.getY() == laserLabel3.getY() + 10 && Rocket.getX() == laserLabel3.getX() - 20 || Rocket.getY() == laserLabel3.getY() - 10 && Rocket.getX() == laserLabel3.getX() - 20 || Rocket.getY() == laserLabel3.getY() - 30 && Rocket.getX() == laserLabel3.getX() - 20)) {
                System.out.println("laser3");

                java.util.List<Integer> xList = Arrays.asList(60, 120, 180, 240, 300, 360, 420, 480, 540);
                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));
                System.out.println(Rocket.getLocation());
                System.out.println(laserLabel3.getLocation());
                Health -= 10;
                dmgClip.start();
                dmgClip.setMicrosecondPosition(0);
                HP.setValue(Health);
                laserLabel3.setLocation(xrandomElement, yrandomElement);
            }
            if ((Rocket.getY() == laserLabel4.getY() + 110 && Rocket.getX() == laserLabel4.getX() - 20 || Rocket.getY() == laserLabel4.getY() + 90 && Rocket.getX() == laserLabel4.getX() - 20 || Rocket.getY() == laserLabel4.getY() + 70 && Rocket.getX() == laserLabel4.getX() - 20 || Rocket.getY() == laserLabel4.getY() + 50 && Rocket.getX() == laserLabel4.getX() - 20 || Rocket.getY() == laserLabel4.getY() + 30 && Rocket.getX() == laserLabel4.getX() - 20 || Rocket.getY() == laserLabel4.getY() + 10 && Rocket.getX() == laserLabel4.getX() - 20 || Rocket.getY() == laserLabel4.getY() - 10 && Rocket.getX() == laserLabel4.getX() - 20 || Rocket.getY() == laserLabel4.getY() - 30 && Rocket.getX() == laserLabel4.getX() - 20)) {
                System.out.println("laser4");


                java.util.List<Integer> xList = Arrays.asList(60, 120, 180, 240, 300, 360, 420, 480, 540);
                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));
                System.out.println(Rocket.getLocation());
                System.out.println(laserLabel4.getLocation());
                Health -= 10;
                dmgClip.start();
                dmgClip.setMicrosecondPosition(0);
                HP.setValue(Health);
                laserLabel4.setLocation(xrandomElement, yrandomElement);
            }
            if ((Rocket.getY() == laserLabel5.getY() + 110 && Rocket.getX() == laserLabel5.getX() - 20 || Rocket.getY() == laserLabel5.getY() + 90 && Rocket.getX() == laserLabel5.getX() - 20 || Rocket.getY() == laserLabel5.getY() + 70 && Rocket.getX() == laserLabel5.getX() - 20 || Rocket.getY() == laserLabel5.getY() + 50 && Rocket.getX() == laserLabel5.getX() - 20 || Rocket.getY() == laserLabel5.getY() + 30 && Rocket.getX() == laserLabel5.getX() - 20 || Rocket.getY() == laserLabel5.getY() + 10 && Rocket.getX() == laserLabel5.getX() - 20 || Rocket.getY() == laserLabel5.getY() - 10 && Rocket.getX() == laserLabel5.getX() - 20 || Rocket.getY() == laserLabel5.getY() - 30 && Rocket.getX() == laserLabel5.getX() - 20)) {

                System.out.println("laser5");

                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));

                System.out.println(Rocket.getLocation());
                System.out.println(laserLabel5.getLocation());
                Health -= 10;
                dmgClip.start();
                dmgClip.setMicrosecondPosition(0);
                HP.setValue(Health);
                laserLabel5.setLocation(xrandomElement, yrandomElement);
            }
            if ((Rocket.getY() == laserLabel6.getY() + 110 && Rocket.getX() == laserLabel6.getX() - 20 || Rocket.getY() == laserLabel6.getY() + 90 && Rocket.getX() == laserLabel6.getX() - 20 || Rocket.getY() == laserLabel6.getY() + 70 && Rocket.getX() == laserLabel6.getX() - 20 || Rocket.getY() == laserLabel6.getY() + 50 && Rocket.getX() == laserLabel6.getX() - 20 || Rocket.getY() == laserLabel6.getY() + 30 && Rocket.getX() == laserLabel6.getX() - 20 || Rocket.getY() == laserLabel6.getY() + 10 && Rocket.getX() == laserLabel6.getX() - 20 || Rocket.getY() == laserLabel6.getY() - 10 && Rocket.getX() == laserLabel6.getX() - 20 || Rocket.getY() == laserLabel6.getY() - 30 && Rocket.getX() == laserLabel6.getX() - 20)) {
                System.out.println("laser6");


                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));

                System.out.println(Rocket.getLocation());
                System.out.println(laserLabel6.getLocation());
                System.out.println("Y&&X");
                Health -= 10;
                dmgClip.start();
                dmgClip.setMicrosecondPosition(0);
                HP.setValue(Health);
                laserLabel6.setLocation(xrandomElement, yrandomElement);
            }

            if ((Rocket.getY() == laserLabel7.getY() + 110 && Rocket.getX() == laserLabel7.getX() - 20 || Rocket.getY() == laserLabel7.getY() + 90 && Rocket.getX() == laserLabel7.getX() - 20 || Rocket.getY() == laserLabel7.getY() + 70 && Rocket.getX() == laserLabel7.getX() - 20 || Rocket.getY() == laserLabel7.getY() + 50 && Rocket.getX() == laserLabel7.getX() - 20 || Rocket.getY() == laserLabel7.getY() + 30 && Rocket.getX() == laserLabel7.getX() - 20 || Rocket.getY() == laserLabel7.getY() + 10 && Rocket.getX() == laserLabel7.getX() - 20 || Rocket.getY() == laserLabel7.getY() - 10 && Rocket.getX() == laserLabel7.getX() - 20 || Rocket.getY() == laserLabel7.getY() - 30 && Rocket.getX() == laserLabel7.getX() - 20)) {
                System.out.println("laser7");
                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));
                laserLabel7.setLocation(xrandomElement, yrandomElement);


                System.out.println(Rocket.getLocation());
                System.out.println(laserLabel7.getLocation());
                System.out.println("Y&&X");
                Health -= 10;
                dmgClip.start();
                dmgClip.setMicrosecondPosition(0);
                HP.setValue(Health);

            }

            if ((Rocket.getY() == laserLabel8.getY() + 110 && Rocket.getX() == laserLabel8.getX() - 20 || Rocket.getY() == laserLabel8.getY() + 90 && Rocket.getX() == laserLabel8.getX() - 20 || Rocket.getY() == laserLabel8.getY() + 70 && Rocket.getX() == laserLabel8.getX() - 20 || Rocket.getY() == laserLabel8.getY() + 50 && Rocket.getX() == laserLabel8.getX() - 20 || Rocket.getY() == laserLabel8.getY() + 30 && Rocket.getX() == laserLabel8.getX() - 20 || Rocket.getY() == laserLabel8.getY() + 10 && Rocket.getX() == laserLabel8.getX() - 20 || Rocket.getY() == laserLabel8.getY() - 10 && Rocket.getX() == laserLabel8.getX() - 20 || Rocket.getY() == laserLabel8.getY() - 30 && Rocket.getX() == laserLabel8.getX() - 20)) {
                System.out.println("laser8");

                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));

                System.out.println(Rocket.getLocation());
                System.out.println(laserLabel8.getLocation());
                System.out.println("Y&&X");
                Health -= 10;
                dmgClip.start();
                dmgClip.setMicrosecondPosition(0);
                HP.setValue(Health);
                laserLabel8.setLocation(xrandomElement, yrandomElement);
            }


            if ((Rocket.getY() == laserLabel9.getY() + 110 && Rocket.getX() == laserLabel9.getX() - 20 || Rocket.getY() == laserLabel9.getY() + 90 && Rocket.getX() == laserLabel9.getX() - 20 || Rocket.getY() == laserLabel9.getY() + 70 && Rocket.getX() == laserLabel9.getX() - 20 || Rocket.getY() == laserLabel9.getY() + 50 && Rocket.getX() == laserLabel9.getX() - 20 || Rocket.getY() == laserLabel9.getY() + 30 && Rocket.getX() == laserLabel9.getX() - 20 || Rocket.getY() == laserLabel9.getY() + 10 && Rocket.getX() == laserLabel9.getX() - 20 || Rocket.getY() == laserLabel9.getY() - 10 && Rocket.getX() == laserLabel9.getX() - 20 || Rocket.getY() == laserLabel9.getY() - 30 && Rocket.getX() == laserLabel9.getX() - 20)) {
                System.out.println("laser9");

                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));

                System.out.println(Rocket.getLocation());
                System.out.println(laserLabel9.getLocation());
                System.out.println("Y&&X");
                Health -= 10;
                dmgClip.start();
                dmgClip.setMicrosecondPosition(0);
                HP.setValue(Health);
                laserLabel9.setLocation(xrandomElement, yrandomElement);
            }


            if ((Rocket.getY() == laserLabel10.getY() + 110 && Rocket.getX() == laserLabel10.getX() - 20 || Rocket.getY() == laserLabel10.getY() + 90 && Rocket.getX() == laserLabel10.getX() - 20 || Rocket.getY() == laserLabel10.getY() + 70 && Rocket.getX() == laserLabel10.getX() - 20 || Rocket.getY() == laserLabel10.getY() + 50 && Rocket.getX() == laserLabel10.getX() - 20 || Rocket.getY() == laserLabel10.getY() + 30 && Rocket.getX() == laserLabel10.getX() - 20 || Rocket.getY() == laserLabel10.getY() + 10 && Rocket.getX() == laserLabel10.getX() - 20 || Rocket.getY() == laserLabel10.getY() - 10 && Rocket.getX() == laserLabel10.getX() - 20 || Rocket.getY() == laserLabel10.getY() - 30 && Rocket.getX() == laserLabel10.getX() - 20)) {
                System.out.println("laser10");

                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));

                System.out.println(Rocket.getLocation());
                System.out.println(laserLabel10.getLocation());
                System.out.println("Y&&X");
                Health -= 10;
                dmgClip.start();
                dmgClip.setMicrosecondPosition(0);
                HP.setValue(Health);
                laserLabel10.setLocation(xrandomElement, yrandomElement);
            }


            if ((Rocket.getY() == laserLabel11.getY() + 110 && Rocket.getX() == laserLabel11.getX() - 20 || Rocket.getY() == laserLabel11.getY() + 90 && Rocket.getX() == laserLabel11.getX() - 20 || Rocket.getY() == laserLabel11.getY() + 70 && Rocket.getX() == laserLabel11.getX() - 20 || Rocket.getY() == laserLabel11.getY() + 50 && Rocket.getX() == laserLabel11.getX() - 20 || Rocket.getY() == laserLabel11.getY() + 30 && Rocket.getX() == laserLabel11.getX() - 20 || Rocket.getY() == laserLabel11.getY() + 10 && Rocket.getX() == laserLabel11.getX() - 20 || Rocket.getY() == laserLabel11.getY() - 10 && Rocket.getX() == laserLabel11.getX() - 20 || Rocket.getY() == laserLabel11.getY() - 30 && Rocket.getX() == laserLabel11.getX() - 20)) {
                System.out.println("laser11");

                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));

                System.out.println(Rocket.getLocation());
                System.out.println(laserLabel11.getLocation());
                System.out.println("Y&&X");
                Health -= 10;
                dmgClip.start();
                dmgClip.setMicrosecondPosition(0);
                HP.setValue(Health);

                laserLabel11.setLocation(xrandomElement, yrandomElement);
            }


            if (restart.isVisible()) {
                this.dispose();
                new test();
            }
            if ((Rocket.getY() == laserLabel12.getY() + 110 && Rocket.getX() == laserLabel12.getX() - 20 || Rocket.getY() == laserLabel12.getY() + 90 && Rocket.getX() == laserLabel12.getX() - 20 || Rocket.getY() == laserLabel12.getY() + 70 && Rocket.getX() == laserLabel12.getX() - 20 || Rocket.getY() == laserLabel12.getY() + 50 && Rocket.getX() == laserLabel12.getX() - 20 || Rocket.getY() == laserLabel12.getY() + 30 && Rocket.getX() == laserLabel12.getX() - 20 || Rocket.getY() == laserLabel12.getY() + 10 && Rocket.getX() == laserLabel12.getX() - 20 || Rocket.getY() == laserLabel12.getY() - 10 && Rocket.getX() == laserLabel12.getX() - 20 || Rocket.getY() == laserLabel12.getY() - 30 && Rocket.getX() == laserLabel12.getX() - 20)) {
                System.out.println("laser12");

                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));

                System.out.println(Rocket.getLocation());
                System.out.println(laserLabel12.getLocation());
                System.out.println("Y&&X");
                Health -= 10;
                dmgClip.start();
                dmgClip.setMicrosecondPosition(0);
                HP.setValue(Health);
                laserLabel12.setLocation(xrandomElement, yrandomElement);
            }


            if ((Rocket.getY() == laserLabel13.getY() + 110 && Rocket.getX() == laserLabel13.getX() - 20 || Rocket.getY() == laserLabel13.getY() + 90 && Rocket.getX() == laserLabel13.getX() - 20 || Rocket.getY() == laserLabel13.getY() + 70 && Rocket.getX() == laserLabel13.getX() - 20 || Rocket.getY() == laserLabel13.getY() + 50 && Rocket.getX() == laserLabel13.getX() - 20 || Rocket.getY() == laserLabel13.getY() + 30 && Rocket.getX() == laserLabel13.getX() - 20 || Rocket.getY() == laserLabel13.getY() + 10 && Rocket.getX() == laserLabel13.getX() - 20 || Rocket.getY() == laserLabel13.getY() - 10 && Rocket.getX() == laserLabel13.getX() - 20 || Rocket.getY() == laserLabel13.getY() - 30 && Rocket.getX() == laserLabel13.getX() - 20)) {
                System.out.println("laser13");

                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));

                System.out.println(Rocket.getLocation());
                System.out.println(laserLabel13.getLocation());
                Health -= 10;
                dmgClip.start();
                dmgClip.setMicrosecondPosition(0);
                HP.setValue(Health);
                laserLabel13.setLocation(xrandomElement, yrandomElement);
            }

            if ((Rocket.getY() == greenlaser.getY() + 110 && Rocket.getX() == greenlaser.getX() - 20 || Rocket.getY() == greenlaser.getY() + 90 && Rocket.getX() == greenlaser.getX() - 20 || Rocket.getY() == greenlaser.getY() + 70 && Rocket.getX() == greenlaser.getX() - 20 || Rocket.getY() == greenlaser.getY() + 50 && Rocket.getX() == greenlaser.getX() - 20 || Rocket.getY() == greenlaser.getY() + 30 && Rocket.getX() == greenlaser.getX() - 20 || Rocket.getY() == greenlaser.getY() + 10 && Rocket.getX() == greenlaser.getX() - 20 || Rocket.getY() == greenlaser.getY() - 10 && Rocket.getX() == greenlaser.getX() - 20 || Rocket.getY() == greenlaser.getY() - 30 && Rocket.getX() == greenlaser.getX() - 20)) {
                System.out.println("Green laser");

                java.util.List<Integer> yList = Arrays.asList( 0, 20, 40, -20, -40,-60,-80,-100,-120,-140,-160);
                java.util.List<Integer> xList = Arrays.asList(0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240, 260, 280, 300, 320, 340, 360, 380, 400, 420, 440, 460, 480, 500, 520, 540);

                int xrandomElement = xList.get(Random.nextInt(xList.size()));
                int yrandomElement = yList.get(Random.nextInt(yList.size()));

                System.out.println(Rocket.getLocation());
                System.out.println(greenlaser.getLocation());
                Health -= 20;
                dmgClip.start();
                dmgClip.setMicrosecondPosition(0);
                HP.setValue(Health);
                greenlaser.setLocation(xrandomElement, yrandomElement);
            }

            if (Health <= 0) {
                t.stop();
                start=2;

                countdownLabel.setBounds(470, 0, 100, 50);
                countdownLabel.setText("Time left  : " + format(time / 60) + ":" + format(time % 60));
                countdownLabel.setForeground(Color.red.darker());
                textfield.setBounds(0, 50, 600, 150);
                textfield.setVisible(true);
                textfield.setText("You died !");
                getContentPane().removeAll();
                repaint();


                this.add(countdownLabel);
                this.add(textfield);
                this.add(HP);


            }
        }

        loseClip.start();
        loseClip.setFramePosition(0);


        System.out.println(Health);


    }

    public void move() throws IOException, InterruptedException {
        if (start == 0) {


            if (time >= 40) {


                Thread.sleep(35);


            }
            if (time >= 25){
                Thread.sleep(30);
            }
            if (time >= 0){
                Thread.sleep(25);
            }
            if (time<=19){
                greenlaser.setVisible(true);
                greenlaser.setLocation(greenlaser.getX(), greenlaser.getY() + 20);

            }

            laserLabel.setLocation(laserLabel.getX(), laserLabel.getY() + 20);
            laserLabel2.setLocation(laserLabel2.getX(), laserLabel2.getY() + 20);
            laserLabel3.setLocation(laserLabel3.getX(), laserLabel3.getY() + 20);
            laserLabel4.setLocation(laserLabel4.getX(), laserLabel4.getY() + 20);
            laserLabel5.setLocation(laserLabel5.getX(), laserLabel5.getY() + 20);
            laserLabel6.setLocation(laserLabel6.getX(), laserLabel6.getY() + 20);
            laserLabel7.setLocation(laserLabel7.getX(), laserLabel7.getY() + 20);
            laserLabel8.setLocation(laserLabel8.getX(), laserLabel8.getY() + 20);
            laserLabel9.setLocation(laserLabel9.getX(), laserLabel9.getY() + 20);
            laserLabel10.setLocation(laserLabel10.getX(), laserLabel10.getY() + 20);
            laserLabel11.setLocation(laserLabel11.getX(), laserLabel11.getY() + 20);
            laserLabel12.setLocation(laserLabel12.getX(), laserLabel12.getY() + 20);
            laserLabel13.setLocation(laserLabel13.getX(), laserLabel13.getY() + 20);



        }

    }



    private static String format(int i) {
        String result = valueOf(i);
        if (result.length() == 1) {
            result = "0" + result;
        }
        return result;

    }

    @Override
    public void keyTyped(KeyEvent e) {


        if (e.getKeyChar()=='h'){
            Health=100;
            HP.setValue(Health);

        }

        if (e.getKeyChar()=='g'){
            restart.setVisible(true);

        }


        if (e.getKeyChar()=='i'){
            System.out.println(this.getAlignmentY());
            System.out.println(this.getSize());
            System.out.println(Rocket.getSize());
            System.out.println(iamgeList1.size());
//
            System.out.println(Rocket.getLocation());
        }

        if (start == 0) {
            if (Rocket.getLocation().getX() == -20 && Rocket.getLocation().getY() == 410) {


                switch (e.getKeyChar()) {
                    case 'w' -> Rocket.setLocation(Rocket.getX(), Rocket.getY() - 20);
                    case 'd' ->{ Rocket.setLocation(Rocket.getX() + 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() + 20, Rocket2.getY());
                    }


                }
            } else if (Rocket.getLocation().getX() == 520 && Rocket.getLocation().getY() == 410) {


                switch (e.getKeyChar()) {
                    case 'w' -> Rocket.setLocation(Rocket.getX(), Rocket.getY() - 20);


                    case 'a' -> {Rocket.setLocation(Rocket.getX() - 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() - 20, Rocket2.getY());
                    }

                }
            } else if (Rocket.getLocation().getX() == -20 && Rocket.getLocation().getY() == 10) {


                switch (e.getKeyChar()) {
                    case 'd' ->{ Rocket.setLocation(Rocket.getX() + 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() + 20, Rocket2.getY());
                    }



                    case 's' -> Rocket.setLocation(Rocket.getX(), Rocket.getY() + 20);

                }
            } else if (Rocket.getLocation().getX() == 520 && Rocket.getLocation().getY() == 10) {


                switch (e.getKeyChar()) {
                    case 's' -> Rocket.setLocation(Rocket.getX(), Rocket.getY() + 20);


                    case 'a' -> {Rocket.setLocation(Rocket.getX() - 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() - 20, Rocket2.getY());
                    }



                }
            } else if (Rocket.getLocation().getX() == -20) {


                switch (e.getKeyChar()) {
                    case 'w' -> Rocket.setLocation(Rocket.getX(), Rocket.getY() - 20);

                    case 's' -> Rocket.setLocation(Rocket.getX(), Rocket.getY() + 20);
                    case 'd' ->{ Rocket.setLocation(Rocket.getX() + 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() + 20, Rocket2.getY());
                    }



                }
            } else if (Rocket.getLocation().getX() == 520) {


                switch (e.getKeyChar()) {
                    case 'w' -> Rocket.setLocation(Rocket.getX(), Rocket.getY() - 20);

                    case 's' -> Rocket.setLocation(Rocket.getX(), Rocket.getY() + 20);


                    case 'a' -> {Rocket.setLocation(Rocket.getX() - 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() - 20, Rocket2.getY());
                    }


                }
            } else if (Rocket.getLocation().getY() == 410) {


                switch (e.getKeyChar()) {
                    case 'w' -> Rocket.setLocation(Rocket.getX(), Rocket.getY() - 20);
                    case 'd' ->{ Rocket.setLocation(Rocket.getX() + 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() + 20, Rocket2.getY());
                    }

                    case 'a' -> {Rocket.setLocation(Rocket.getX() - 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() - 20, Rocket2.getY());
                    }


                }

            } else if (Rocket.getLocation().getY() == 10) {


                switch (e.getKeyChar()) {
                    case 's' -> Rocket.setLocation(Rocket.getX(), Rocket.getY() + 20);
                    case 'd' ->{ Rocket.setLocation(Rocket.getX() + 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() + 20, Rocket2.getY());
                    }

                    case 'a' -> {Rocket.setLocation(Rocket.getX() - 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() - 20, Rocket2.getY());
                    }


                }
            } else {
                switch (e.getKeyChar()) {
                    case 'w' -> Rocket.setLocation(Rocket.getX(), Rocket.getY() - 20);
                    case 's' -> {Rocket.setLocation(Rocket.getX(), Rocket.getY() + 20);}
                    case 'd' ->{ Rocket.setLocation(Rocket.getX() + 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() + 20, Rocket2.getY());
                    }

                    case 'a' -> {Rocket.setLocation(Rocket.getX() - 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() - 20, Rocket2.getY());
                    }


                }
            }

        }

    }

    @Override
    public void keyPressed(KeyEvent e) {


    }

    @Override
    public void keyReleased(KeyEvent e) {
     System.out.println("You released key code: " + e.getKeyCode());




        switch (e.getKeyCode()) {

            case 10 -> {
                if (time != 0) {
                    if (Health >= 0&&start==1) {
                        System.out.println("Asd");

                        getContentPane().removeAll();
                        countdownLabel.setBounds(550, 0, 50, 20);

                        countdownLabel.setIcon(null);
                        repaint();

                        this.add(Rocket);
                        this.add(laserLabel);
                        this.add(laserLabel2);
                        this.add(laserLabel3);
                        this.add(laserLabel4);
                        this.add(laserLabel5);
                        this.add(laserLabel6);
                        this.add(laserLabel7);
                        this.add(laserLabel8);
                        this.add(laserLabel9);
                        this.add(laserLabel10);
                        this.add(laserLabel11);
                        this.add(laserLabel12);
                        this.add(laserLabel13);
                        this.add(countdownLabel);

                        this.add(Rocket2);
                        this.add(greenlaser);
                        this.add(HP);
                        this.add(healthpackLabel);
                        this.add(healthpackLabel2);
                        this.add(spacelabel);
                        t.start();


                        start = 0;

                    }


                }
            }
            case 32 -> {

                if (start == 0) {
                    getContentPane().removeAll();

                    titlelabel.setText("Space Rocket Game   ");
                    titlelabel.setIcon(rocketImage);
                    titlelabel.setBounds(0, 0, 750, 150);
                    titlelabel.setIconTextGap(-350);

                    startlabel.setBounds(0, 200, 350, 50);
                    exitlabel.setBounds(0, 340, 350, 50);

                    exitlabel.setText("press Esc to exit the game ");

                    startlabel.setText("Press Enter to unpause the game ");
                    repaint();
                    this.add(startlabel);
                    this.add(exitlabel);
                    this.add(titlelabel);
                    this.add(spacelabel);

                    t.stop();

                    start = 1;
                }
            }

            case 27 -> System.exit(0);
        }

//up=38,right=39,down=40,left=37

        if (start == 0) {
            if (Rocket.getLocation().getX() == -20 && Rocket.getLocation().getY() == 410) {


                switch (e.getKeyCode()) {
                    case 38 -> Rocket.setLocation(Rocket.getX(), Rocket.getY() - 20);
                    case 39 ->{ Rocket.setLocation(Rocket.getX() + 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() + 20, Rocket2.getY());
                    }


                }
            } else if (Rocket.getLocation().getX() == 520 && Rocket.getLocation().getY() == 410) {


                switch (e.getKeyCode()) {
                    case 38 -> Rocket.setLocation(Rocket.getX(), Rocket.getY() - 20);


                    case 37 -> {Rocket.setLocation(Rocket.getX() - 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() - 20, Rocket2.getY());
                    }

                }
            } else if (Rocket.getLocation().getX() == -20 && Rocket.getLocation().getY() == 10) {


                switch (e.getKeyCode()) {
                    case 39 ->{ Rocket.setLocation(Rocket.getX() + 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() + 20, Rocket2.getY());
                    }



                    case 40 -> Rocket.setLocation(Rocket.getX(), Rocket.getY() + 20);

                }
            } else if (Rocket.getLocation().getX() == 520 && Rocket.getLocation().getY() == 10) {


                switch (e.getKeyCode()) {
                    case 40 -> Rocket.setLocation(Rocket.getX(), Rocket.getY() + 20);


                    case 37 -> {Rocket.setLocation(Rocket.getX() - 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() - 20, Rocket2.getY());
                    }



                }
            } else if (Rocket.getLocation().getX() == -20) {


                switch (e.getKeyCode()) {
                    case 38 -> Rocket.setLocation(Rocket.getX(), Rocket.getY() - 20);

                    case 40 -> Rocket.setLocation(Rocket.getX(), Rocket.getY() + 20);
                    case 39 ->{ Rocket.setLocation(Rocket.getX() + 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() + 20, Rocket2.getY());
                    }



                }
            } else if (Rocket.getLocation().getX() == 520) {


                switch (e.getKeyCode()) {
                    case 38 -> Rocket.setLocation(Rocket.getX(), Rocket.getY() - 20);

                    case 40 -> Rocket.setLocation(Rocket.getX(), Rocket.getY() + 20);


                    case 37 -> {Rocket.setLocation(Rocket.getX() - 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() - 20, Rocket2.getY());
                    }


                }
            } else if (Rocket.getLocation().getY() == 410) {


                switch (e.getKeyCode()) {
                    case 38 -> Rocket.setLocation(Rocket.getX(), Rocket.getY() - 20);
                    case 39 ->{ Rocket.setLocation(Rocket.getX() + 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() + 20, Rocket2.getY());
                    }

                    case 37 -> {Rocket.setLocation(Rocket.getX() - 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() - 20, Rocket2.getY());
                    }


                }

            } else if (Rocket.getLocation().getY() == 10) {


                switch (e.getKeyCode()) {
                    case 40 -> Rocket.setLocation(Rocket.getX(), Rocket.getY() + 20);
                    case 39 ->{ Rocket.setLocation(Rocket.getX() + 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() + 20, Rocket2.getY());
                    }

                    case 37 -> {Rocket.setLocation(Rocket.getX() - 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() - 20, Rocket2.getY());
                    }


                }
            } else {
                switch (e.getKeyCode()) {
                    case 38 -> Rocket.setLocation(Rocket.getX(), Rocket.getY() - 20);
                    case 40 -> {Rocket.setLocation(Rocket.getX(), Rocket.getY() + 20);}
                    case 39 ->{ Rocket.setLocation(Rocket.getX() + 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() + 20, Rocket2.getY());
                    }

                    case 37 -> {Rocket.setLocation(Rocket.getX() - 20, Rocket.getY());
                        Rocket2.setLocation(Rocket2.getX() - 20, Rocket2.getY());
                    }


                }
            }

        }

    }





    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==howtoplay){
            t.stop();
            getContentPane().removeAll();

            textfield.setText("OR");
            ImageIcon arrowkeys= new ImageIcon("Resources/arrowKeys.png");
            textfield.setBounds(200, 300, 100, 50);
            textfield.setVisible(true);
            countdownLabel.setIcon(arrowkeys);
            countdownLabel.setBounds(350, 300, 200, 135);
            startlabel.setBounds(60, 190, 50, 50);
            titlelabel.setBounds(0, 250, 50, 50);
            pauselabel.setBounds(60, 250, 50, 50);
            exitlabel.setBounds(120, 250, 50, 50);



            playLabel.setBounds(0, 0, 750, 150);

            playLabel.setBackground(new Color(42, 41, 41));

            playLabel.setForeground(new Color(7, 165, 162));

            playLabel.setFont(new Font("Ink Free", Font.BOLD, 30));

            playLabel.setBorder(BorderFactory.createBevelBorder(1));

            playLabel.setHorizontalAlignment(JLabel.CENTER);
            playLabel.setText("Press Enter to play the game  ");
            startlabel.setText("W");
            titlelabel.setText("A");
            pauselabel.setText("S");

            exitlabel.setText("D");
            titlelabel.setIcon(null);
            repaint();
            this.add(countdownLabel);
            this.add(startlabel);
            this.add(titlelabel);
            this.add(exitlabel);
            this.add(pauselabel);
            this.add(textfield);
            this.add(playLabel);
            start=1;
        }


        if (e.getSource() == exitItem) {
            System.exit(0);
        }

        if (e.getSource() == framecoloritem) {
            JColorChooser colorChooser = new JColorChooser();
            Color color = JColorChooser.showDialog(null, "Pick a color", Color.black);
            this.getContentPane().setBackground(color);
            repaint();

        }
        if (e.getSource() ==themeimage) {

            this.getContentPane().add(spacelabel);
            repaint();









        }
        if(e.getSource()==textcoloritem){
            JColorChooser colorChooser = new JColorChooser();
            Color color = JColorChooser.showDialog(null, "Pick a color", Color.black);
            playLabel.setForeground(color);
            titlelabel.setForeground(color);
            startlabel.setForeground(color);
            pauselabel.setForeground(color);
            exitlabel.setForeground(color);
            textfield.setForeground(color);

        }


        if (e.getSource() == restoredefaults) {

            this.getContentPane().setBackground(Color.black.darker().darker());
            titlelabel.setForeground(new Color(7, 165, 162));
            startlabel.setForeground(new Color(7, 165, 162));
            pauselabel.setForeground(new Color(7, 165, 162));
            exitlabel.setForeground(new Color(7, 165, 162));
            textfield.setForeground(new Color(7, 165, 162));
            playLabel.setForeground(new Color(7, 165, 162));
            spacelabel.setIcon(spaceImage);
        }
        if (e.getSource() == removeimage) {

            spacelabel.setIcon(null);
        }
    }


    public static BufferedImage colorImage(BufferedImage image) throws IOException {
        int s= 0;

        ImageIcon rocketImage = new ImageIcon("Resources/Rocket.png");

        int width = image.getWidth();
        int height = image.getHeight();
        WritableRaster raster = image.getRaster();
        JColorChooser colorChooser = new JColorChooser();
        Color color = JColorChooser.showDialog(null, "Pick a color", Color.black);
        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);

                pixels[0] = color.getRed();
                pixels[1] = color.getGreen();
                pixels[2] = color.getBlue();
                raster.setPixel(xx, yy, pixels);
            }
        }
        return image;
    }
}

