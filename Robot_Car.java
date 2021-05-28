/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* COM162 Assignment 170153599 170153038 */

package robot_test;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.event.*;
import ShefRobot.*;
import static java.lang.Integer.valueOf;

class ActionEventDemo implements ActionListener {

    private static int Motorspeed = 200;
    private static int Angle = 360;
    JFrame frame = new JFrame();       //Define user interface
    //Create new buttons
    JButton Forward = new JButton("Forward");           
    JButton Backward = new JButton("Backward");
    JButton setMotorSpeed = new JButton("setSpeed");
    JButton Release = new JButton("Release");
    JButton Right = new JButton("Right");
    JButton Left = new JButton("Left");
    JButton Sing = new JButton("Sing");
    JButton precisegrab = new JButton("Grab");
    JButton setAngle = new JButton("setAngle");
    JButton close = new JButton("close");

    ActionEventDemo() {
        prepareGUI();
        buttonProperties();

    }

    public void prepareGUI() {
        //Set frame properties
        frame.setTitle("My Window");
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setBounds(200, 200, 400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void buttonProperties() {
        //Set button properties
        Forward.setBounds(50, 100, 100, 40);
        Backward.setBounds(50, 200, 100, 40);
        setMotorSpeed.setBounds(150, 100, 100, 40);
        Release.setBounds(150, 200, 100, 40);
        Right.setBounds(250, 100, 100, 40);
        Left.setBounds(250, 200, 100, 40);
        Sing.setBounds(150, 250, 100, 40);
        precisegrab.setBounds(150, 200, 100, 40);
        setAngle.setBounds(150, 150, 100, 40);
        close.setBounds(150, 300, 100, 40);
        //Add buttons to frame
        frame.add(Forward);
        frame.add(Backward);
        frame.add(setMotorSpeed);
        frame.add(setAngle);
        frame.add(Right);
        frame.add(Left);
        frame.add(Sing);
        frame.add(precisegrab);
        frame.add(close);
        //Add buttons to Action Listners
        Forward.addActionListener(this);
        Backward.addActionListener(this);
        setMotorSpeed.addActionListener(this);
        setAngle.addActionListener(this);
        Right.addActionListener(this);
        Left.addActionListener(this);
        Sing.addActionListener(this);
        precisegrab.addActionListener(this);
        close.addActionListener(this);

    }

    public void checkMotor() {
        //Connect to robot and motors
        Robot myRobot = new Robot("dia-lego-g2");
        Motor leftMotor = myRobot.getLargeMotor(Motor.Port.B);
        Motor rightMotor = myRobot.getLargeMotor(Motor.Port.C);
        Motor grab = myRobot.getLargeMotor(Motor.Port.A);
        //Check if all motors are connected
        if (leftMotor.isStalled() == false || rightMotor.isStalled() == false || grab.isStalled() == false) {
            //Sing a high pitched sound if all motors are correctly connected
            Speaker speaker = myRobot.getSpeaker();
            speaker.playTone(1000, 1000);
            System.out.println("All motor connected, ready to go");
        } else {
            //Sing four low pitched sound if not
            Speaker speaker = myRobot.getSpeaker();
            speaker.playTone(100, 100);
            speaker.playTone(100, 100);
            speaker.playTone(100, 100);
            speaker.playTone(100, 100);
            System.out.println("One of the motor isn't connected");
        }
    }

    public void setMotorSpeed(int inputSpeed) {
        Motorspeed = inputSpeed;
    }

    public int getMotorSpeed() {
        return Motorspeed;
    }

    public void setAngle(int inputAngle) {
        Angle = inputAngle;
    }

    public int getAngle() {
        return Angle;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //connect to the robot and motors
        Robot myRobot = new Robot("dia-lego-g2");
        Motor leftMotor = myRobot.getLargeMotor(Motor.Port.B);
        Motor rightMotor = myRobot.getLargeMotor(Motor.Port.C);
        Motor grab = myRobot.getLargeMotor(Motor.Port.A);
        //set the necessary index
        int setindex;
        int sleepindex;
        double grabindex;
        int angleindex;

        if (e.getSource() == Forward) {
            //the user should enter the sleep index to define the sleep time for the robot, 
            //the time(length) that the robot goes forward
            sleepindex = valueOf(JOptionPane.showInputDialog("Input the sleepindex to go forward"));
            leftMotor.setSpeed(Motorspeed);
            rightMotor.setSpeed(Motorspeed);
            leftMotor.forward();
            rightMotor.forward();
            myRobot.sleep((int) sleepindex * 100);
            leftMotor.stop();
            rightMotor.stop();

        }
        if (e.getSource() == Backward) {
            //the user should enter the sleep index to define the sleep time for the robot, 
            //the time(length) that the robot goes backward            
            sleepindex = valueOf(JOptionPane.showInputDialog("Input the sleepindex to go backward"));
            leftMotor.setSpeed(Motorspeed);
            rightMotor.setSpeed(Motorspeed);
            leftMotor.backward();
            rightMotor.backward();
            myRobot.sleep((int) sleepindex * 100);
            leftMotor.stop();
            rightMotor.stop();

        }
        if (e.getSource() == setMotorSpeed) {
            //the user should input the new motor(motor B C) speed if any change is required
            setindex = valueOf(JOptionPane.showInputDialog("Please enter perfered motor speed"));
            setMotorSpeed(setindex);
            getMotorSpeed();

        }
        if (e.getSource() == setAngle) {
            //the user should input the new angle of turning(motor A) if any change is required
            angleindex = valueOf(JOptionPane.showInputDialog("Please enter perfered motor speed"));
            setAngle(angleindex);
            getAngle();

        }

        if (e.getSource() == Sing) {
            //user the speaker from the robot and sing
            Speaker speaker = myRobot.getSpeaker();

            speaker.playTone(100, 100);
            speaker.playTone(200, 100);
            speaker.playTone(300, 100);
            speaker.playTone(400, 100);
            speaker.playTone(500, 100);
            speaker.playTone(600, 100);
            speaker.playTone(700, 100);
            speaker.playTone(800, 100);
            speaker.playTone(900, 100);
            speaker.playTone(1000, 100);
        }

        if (e.getSource() == Left) {
            sleepindex = valueOf(JOptionPane.showInputDialog("Please enter time index to turn left"));
            leftMotor.setSpeed(Motorspeed);
            rightMotor.setSpeed(Motorspeed);
            leftMotor.backward();
            rightMotor.forward();
            myRobot.sleep((int) sleepindex * 100);
            leftMotor.stop();
            rightMotor.stop();
        }

        if (e.getSource() == Right) {
            sleepindex = valueOf(JOptionPane.showInputDialog("Please enter time index to turn right"));
            leftMotor.setSpeed(Motorspeed);
            rightMotor.setSpeed(Motorspeed);
            leftMotor.forward();
            rightMotor.backward();
            myRobot.sleep((int) sleepindex * 100);
            leftMotor.stop();
            rightMotor.stop();
        }
        if (e.getSource() == precisegrab) {
            //enter the grab index to open or close the claw
            grabindex = Double.valueOf(JOptionPane.showInputDialog("Enter the grab index"));
            grab.rotate((int) (Angle * grabindex));

        }

        if (e.getSource() == close) {
            //exit the program
            myRobot.close();
            System.exit(0);

        }
        //disconnect the robot
        myRobot.close();

    }
}

public class G2_Robot {

    public static void main(String[] args) {
        ActionEventDemo button = new ActionEventDemo();
        button.checkMotor();
    }
}