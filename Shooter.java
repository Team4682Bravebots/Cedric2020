package frc.robot;

import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


// TODO: Need Feeder Pneumatics for 4 and 5
public class Shooter {
    private double kDefaultPower = 0.45;
    private static final double kOffPower = 0.0;
    private boolean shooterrunning;

    private CANSparkMax CSM1;
    private CANSparkMax CSM0;

    public Shooter(int port1, int port2) {
        CSM0 = new CANSparkMax(port1, CANSparkMaxLowLevel.MotorType.kBrushless);
        CSM0.restoreFactoryDefaults();
        CSM1 = new CANSparkMax(port2, CANSparkMaxLowLevel.MotorType.kBrushless);
        CSM1.restoreFactoryDefaults();
        CANEncoder Enc;
        Enc = CSM0.getEncoder();
        
        
        stop();
    }

    public void setPower(double power) {
        CSM0.set(-power);
        CSM1.set(power);
        shooterrunning = true;

    }

    public void stop() {
        setPower(kOffPower);
        shooterrunning = false;
    }

    public void shoot() {
        setPower(kDefaultPower);
        
    }

    public double Getmotorvelocity() {
        return CSM0.getEncoder().getVelocity();
        
    }


    public void debug() {
        SmartDashboard.putBoolean("shooter running?", shooterrunning);
        SmartDashboard.putNumber("Shooter velocity", CSM0.getEncoder().getVelocity());    
        SmartDashboard.setDefaultNumber("targetPower", kDefaultPower);
        kDefaultPower = SmartDashboard.getNumber("targetPower", kDefaultPower);
    }

}
